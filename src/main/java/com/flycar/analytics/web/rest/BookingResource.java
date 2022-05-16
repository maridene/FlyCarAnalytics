package com.flycar.analytics.web.rest;

import com.flycar.analytics.domain.Booking;
import com.flycar.analytics.repository.BookingRepository;
import com.flycar.analytics.service.BookingService;
import com.flycar.analytics.service.dto.BookingsPerAgencyDTO;
import com.flycar.analytics.service.dto.BookingsVehicleCategoryDTO;
import com.flycar.analytics.service.dto.RevenueDTO;
import com.flycar.analytics.service.dto.SelfVSBorrowedDTO;

import java.math.BigInteger;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.PaginationUtil;

/**
 * REST controller for managing {@link com.flycar.analytics.domain.Booking}.
 */
@RestController
@RequestMapping("/api")
public class BookingResource {

    private final Logger log = LoggerFactory.getLogger(BookingResource.class);

    private static final String ENTITY_NAME = "booking";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final BookingService bookingService;

    private final BookingRepository bookingRepository;

    public BookingResource(BookingService bookingService, BookingRepository bookingRepository) {
        this.bookingService = bookingService;
        this.bookingRepository = bookingRepository;
    }

    /**
     * {@code GET  /bookings} : get all the bookings.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of bookings in body.
     */
    @GetMapping("/bookings")
    public ResponseEntity<List<Booking>> getAllBookings(@org.springdoc.api.annotations.ParameterObject Pageable pageable) {
        log.debug("REST request to get a page of Bookings");
        Page<Booking> page = bookingService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @GetMapping("/bookings/self_vs_borrowed")
    public ResponseEntity<SelfVSBorrowedDTO> getAllBookings() {
        log.debug("REST request to get a page of Bookings");
        SelfVSBorrowedDTO dto = bookingService.getSelfVsBorrowed();
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok().headers(headers).body(dto);
    }

    @GetMapping("/bookings/mostWantedCategories")
    public ResponseEntity<List<BookingsVehicleCategoryDTO>> getMostWantedCategories() {
        log.debug("REST request to get a page of Bookings");
        List<BookingsVehicleCategoryDTO> result = bookingService.getBookingsVehicleCategories();
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok().headers(headers).body(result);
    }

    @GetMapping("/bookings/bookingsPerAgency")
    public ResponseEntity<List<BookingsPerAgencyDTO>> getBookingsPerAgency(@RequestParam(name = "dateMask") String dateMask) {
        log.debug("REST request to get a page of Bookings");
        List<BookingsPerAgencyDTO> result = bookingService.getBookingsPerAgency(dateMask);
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok().headers(headers).body(result);
    }

    @GetMapping("/bookings/revenueMonthly")
    public ResponseEntity<List<RevenueDTO>> getRevenueMonthly(@RequestParam(name = "year") String year) {
        log.debug("REST request to get revenue monthly for given year");
        List<RevenueDTO> result = bookingService.getRevenueMonthly(year);
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok().headers(headers).body(result);
    }

    @GetMapping("/bookings/revenueTrimester")
    public ResponseEntity<List<RevenueDTO>> getRevenueTrimester(@RequestParam(name = "year") String year) {
        log.debug("REST request to get revenue per trimester for given year");
        List<RevenueDTO> result = bookingService.getRevenueTrimester(year);
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok().headers(headers).body(result);
    }
}
