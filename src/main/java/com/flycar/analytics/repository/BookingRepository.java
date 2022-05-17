package com.flycar.analytics.repository;

import com.flycar.analytics.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    @Query(value="SELECT vehiclecategory_id, COUNT(*), code, name\n" +
        "FROM bookings LEFT JOIN \"Defvehicle\" ON bookings.vehiclecategory_id = \"Defvehicle\".\"VehicleCategoryId\"\n" +
        "GROUP BY vehiclecategory_id, code, name", nativeQuery=true)
    List<Object[]> getBookingsVehicleCategories();

    //taba3 3ala hedhi
    @Query(value="SELECT b.agency_id, agency_name, agency_code, COUNT(*)\n" +
        "FROM (SELECT bookings.agency_id, \"date\" FROM bookings WHERE to_char(bookings.\"date\",'yyyy-mm-dd') LIKE CONCAT('%', ?1, '%')) AS b LEFT JOIN \"DefAgency\" ON b.agency_id = \"DefAgency\".agency_id\n" +
        "GROUP BY b.agency_id, agency_name, agency_code", nativeQuery=true)
    List<Object[]> getBookingsPerAgency(String dateMask);

    @Query(value="SELECT SUM(rentingrevenue) AS renting, SUM(totalrevenue) AS total FROM bookings WHERE to_char(bookings.\"date\",'yyyy-mm-dd') LIKE CONCAT(?1, '-', ?2, '-%')", nativeQuery=true)
    List<Object[]> getRevenueMonthly(String year, String Month);

    @Query(value="SELECT COUNT(*) AS bookings FROM bookings WHERE to_char(bookings.\"date\",'yyyy-mm-dd') LIKE CONCAT(?1, '-', ?2, '-%')", nativeQuery=true)
    List<Object[]> getBookingsMonthly(String year, String Month);
}
