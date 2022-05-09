package com.flycar.analytics.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 * A Booking.
 */
@Entity
@Table(name = "bookings", schema = "public")
public class Booking implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "\"Id\"")
    private Long id;

    @Column(name = "\"agency_Id\"")
    private int agencyId;

    @Column(name = "vehiclecategory_id")
    private int vehicleCategoryId;

    @Column(name = "channelcode")
    private String channelCode;

    @Column(name = "date")
    private Date date;

    @Column(name = "nbcars")
    private float nbCars;

    @Column(name = "ooo")
    private float ooo;

    @Column(name = "borrowed")
    private float borrowed;

    @Column(name = "rentingrevenue")
    private float rentingRevenue;

    @Column(name = "totalrevenue")
    private float totalRevenue;

    @Column(name = "extractdate")
    private Date extractDate;

    public Booking() {}

    public Booking id(Long id) {
        this.setId(id);
        return this;
    }

    public Booking(
        Long id,
        int agencyId,
        int vehicleCategoryId,
        String channelCode,
        Date date,
        float nbCars,
        float ooo,
        float borrowed,
        float rentingRevenue,
        float totalRevenue,
        Date extractDate
    ) {
        this.id = id;
        this.agencyId = agencyId;
        this.vehicleCategoryId = vehicleCategoryId;
        this.channelCode = channelCode;
        this.date = date;
        this.nbCars = nbCars;
        this.ooo = ooo;
        this.borrowed = borrowed;
        this.rentingRevenue = rentingRevenue;
        this.totalRevenue = totalRevenue;
        this.extractDate = extractDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public int getVehicleCategoryId() {
        return vehicleCategoryId;
    }

    public void setVehicleCategoryId(int vehicleCategoryId) {
        this.vehicleCategoryId = vehicleCategoryId;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getNbCars() {
        return nbCars;
    }

    public void setNbCars(float nbCars) {
        this.nbCars = nbCars;
    }

    public float getOoo() {
        return ooo;
    }

    public void setOoo(float ooo) {
        this.ooo = ooo;
    }

    public float getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(float borrowed) {
        this.borrowed = borrowed;
    }

    public float getRentingRevenue() {
        return rentingRevenue;
    }

    public void setRentingRevenue(float rentingRevenue) {
        this.rentingRevenue = rentingRevenue;
    }

    public float getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(float totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    public Date getExtractDate() {
        return extractDate;
    }

    public void setExtractDate(Date extractDate) {
        this.extractDate = extractDate;
    }

    @Override
    public String toString() {
        return (
            "Booking{" +
            "id=" +
            id +
            ", agencyId=" +
            agencyId +
            ", vehicleCategoryId=" +
            vehicleCategoryId +
            ", channelCode='" +
            channelCode +
            '\'' +
            ", date=" +
            date +
            ", nbCars=" +
            nbCars +
            ", ooo=" +
            ooo +
            ", borrowed=" +
            borrowed +
            ", rentingRevenue=" +
            rentingRevenue +
            ", totalRevenue=" +
            totalRevenue +
            ", extractDate=" +
            extractDate +
            '}'
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return (
            id == booking.id &&
            agencyId == booking.agencyId &&
            vehicleCategoryId == booking.vehicleCategoryId &&
            Float.compare(booking.nbCars, nbCars) == 0 &&
            Float.compare(booking.ooo, ooo) == 0 &&
            Float.compare(booking.borrowed, borrowed) == 0 &&
            Float.compare(booking.rentingRevenue, rentingRevenue) == 0 &&
            Float.compare(booking.totalRevenue, totalRevenue) == 0 &&
            Objects.equals(channelCode, booking.channelCode) &&
            Objects.equals(date, booking.date) &&
            Objects.equals(extractDate, booking.extractDate)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            agencyId,
            vehicleCategoryId,
            channelCode,
            date,
            nbCars,
            ooo,
            borrowed,
            rentingRevenue,
            totalRevenue,
            extractDate
        );
    }
}
