package com.flycar.analytics.service.impl;

import com.flycar.analytics.domain.Booking;
import com.flycar.analytics.repository.BookingRepository;
import com.flycar.analytics.service.BookingService;
import com.flycar.analytics.service.dto.BookingsPerAgencyDTO;
import com.flycar.analytics.service.dto.BookingsVehicleCategoryDTO;
import com.flycar.analytics.service.dto.RevenueDTO;
import com.flycar.analytics.service.dto.SelfVSBorrowedDTO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.util.stream.Collectors.toList;

/**
 * Service Implementation for managing {@link Booking}.
 */
@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    private final Logger log = LoggerFactory.getLogger(BookingServiceImpl.class);

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Booking> findAll(Pageable pageable) {
        log.debug("Request to get all Bookings");
        return bookingRepository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Booking> findAll() {
        log.debug("Request to get all Bookings");
        return bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> findOne(Long id) {
        log.debug("Request to get Booking : {}", id);
        return bookingRepository.findById(id);
    }

    @Override
    public SelfVSBorrowedDTO getSelfVsBorrowed() {
        log.debug("Request to get Self vs Borrowed Bookings");
        List<Booking> all = bookingRepository.findAll();
        int total = all.size();
        List<Booking> borrowed = all.stream().filter(each -> each.getBorrowed() == 1).collect(toList());
        int borrowedCount = borrowed.size();
        SelfVSBorrowedDTO dto = new SelfVSBorrowedDTO(
            ((float) borrowedCount / total) * 100,
            ((float) (total - borrowedCount) / total) * 100
        );
        log.debug("dto result: {}", dto);
        return dto;
    }

    @Override
    public List<BookingsVehicleCategoryDTO> getBookingsVehicleCategories() {
        log.debug("Request to get bookings vehicle categories count");
        List<Object[]> bookingsVehicleCategories = bookingRepository.getBookingsVehicleCategories();
        List<BookingsVehicleCategoryDTO> result = bookingsVehicleCategories.stream()
            .map(each -> {
                BookingsVehicleCategoryDTO dto = new BookingsVehicleCategoryDTO();
                dto.setVehicleCategoryId((int) each[0]);
                dto.setCount((BigInteger) each[1]);
                dto.setCode((String) each[2]);
                dto.setName((String) each[3]);
                return dto;
            }).collect(toList());
        return result;
    }

    @Override
    public List<BookingsPerAgencyDTO> getBookingsPerAgency(String dateMask) {
        log.debug("Request to get bookings per agency for a given date mask");
        List<Object[]> bookingsPerAgency = bookingRepository.getBookingsPerAgency(dateMask);
        List<BookingsPerAgencyDTO> result = bookingsPerAgency.stream()
            .map(each -> {
                BookingsPerAgencyDTO dto = new BookingsPerAgencyDTO();
                dto.setAgencyId((int) each[0]);
                dto.setAgencyName((String) each[1]);
                dto.setAgencyCode((String) each[2]);
                dto.setBookingsCount((BigInteger) each[3]);
                return dto;
            }).collect(toList());
        return result;
    }

    @Override
    public List<RevenueDTO> getRevenueMonthly(String year) {
        String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        return Arrays.stream(months)
            .map(month -> {
                List<Object[]> revenue = bookingRepository.getRevenueMonthly(year, "" + month);
                Float renting = (Float)(Optional.ofNullable(revenue.get(0)[0]).orElse((float)0));
                Float total = (Float)(Optional.ofNullable(revenue.get(0)[1]).orElse((float)0));
                return new RevenueDTO(Math.round(renting), Math.round(total));
            })
            .collect(toList());
    }

    @Override
    public List<RevenueDTO> getRevenueTrimester(String year) {
        List<RevenueDTO> monthly = this.getRevenueMonthly(year);
        List<RevenueDTO> trimester = new ArrayList<>();

        trimester.add(new RevenueDTO(
            monthly.get(0).getRentingRevenue() + monthly.get(1).getRentingRevenue() + monthly.get(2).getRentingRevenue(),
            monthly.get(0).getTotalRevenue() + monthly.get(1).getTotalRevenue() + monthly.get(2).getTotalRevenue()));
        trimester.add(new RevenueDTO(
            monthly.get(3).getRentingRevenue() + monthly.get(4).getRentingRevenue() + monthly.get(5).getRentingRevenue(),
            monthly.get(3).getTotalRevenue() + monthly.get(4).getTotalRevenue() + monthly.get(5).getTotalRevenue()));
        trimester.add(new RevenueDTO(
            monthly.get(6).getRentingRevenue() + monthly.get(7).getRentingRevenue() + monthly.get(8).getRentingRevenue(),
            monthly.get(6).getTotalRevenue() + monthly.get(7).getTotalRevenue() + monthly.get(8).getTotalRevenue()));
        trimester.add(new RevenueDTO(
            monthly.get(9).getRentingRevenue() + monthly.get(10).getRentingRevenue() + monthly.get(11).getRentingRevenue(),
            monthly.get(9).getTotalRevenue() + monthly.get(10).getTotalRevenue() + monthly.get(11).getTotalRevenue()));

        return trimester;
    }

    @Override
    public List<BigInteger> getBookingsMonthly(String year) {
        String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        return Arrays.stream(months)
            .map(month -> {
                List<Object[]> bookings = bookingRepository.getBookingsMonthly(year, "" + month);
                return (BigInteger) bookings.get(0)[0];
            })
            .collect(toList());
    }
}
