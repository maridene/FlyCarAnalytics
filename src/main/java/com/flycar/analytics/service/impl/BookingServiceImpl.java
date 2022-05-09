package com.flycar.analytics.service.impl;

import com.flycar.analytics.domain.Booking;
import com.flycar.analytics.repository.BookingRepository;
import com.flycar.analytics.service.BookingService;
import com.flycar.analytics.service.dto.SelfVSBorrowedDTO;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        List<Booking> borrowed = all.stream().filter(each -> each.getBorrowed() == 1).collect(Collectors.toList());
        int borrowedCount = borrowed.size();
        SelfVSBorrowedDTO dto = new SelfVSBorrowedDTO(
            ((float) borrowedCount / total) * 100,
            ((float) (total - borrowedCount) / total) * 100
        );
        log.debug("dto result: {}", dto);
        return dto;
    }
}
