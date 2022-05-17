package com.flycar.analytics.service;

import com.flycar.analytics.domain.Booking;
import com.flycar.analytics.service.dto.BookingsPerAgencyDTO;
import com.flycar.analytics.service.dto.BookingsVehicleCategoryDTO;
import com.flycar.analytics.service.dto.RevenueDTO;
import com.flycar.analytics.service.dto.SelfVSBorrowedDTO;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link Booking}.
 */
public interface BookingService {
    /**
     * Get all the bookings.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<Booking> findAll(Pageable pageable);

    /**
     * Get all the bookings.
     *
     * @return the list of entities.
     */
    List<Booking> findAll();

    /**
     * Get the "id" booking.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Booking> findOne(Long id);

    SelfVSBorrowedDTO getSelfVsBorrowed();

    List<BookingsVehicleCategoryDTO> getBookingsVehicleCategories();

    List<BookingsPerAgencyDTO> getBookingsPerAgency(String dateMask);

    List<RevenueDTO> getRevenueTrimester(String year);

    List<RevenueDTO> getRevenueMonthly(String year);

    List<BigInteger> getBookingsMonthly(String year);
}
