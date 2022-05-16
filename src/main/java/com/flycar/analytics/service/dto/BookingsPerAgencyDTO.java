package com.flycar.analytics.service.dto;

import java.math.BigInteger;

public class BookingsPerAgencyDTO {
    private int agencyId;
    private String agencyName;
    private String agencyCode;
    private BigInteger bookingsCount;

    public int getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(int agencyId) {
        this.agencyId = agencyId;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getAgencyCode() {
        return agencyCode;
    }

    public void setAgencyCode(String agencyCode) {
        this.agencyCode = agencyCode;
    }

    public BigInteger getBookingsCount() {
        return bookingsCount;
    }

    public void setBookingsCount(BigInteger bookingsCount) {
        this.bookingsCount = bookingsCount;
    }
}
