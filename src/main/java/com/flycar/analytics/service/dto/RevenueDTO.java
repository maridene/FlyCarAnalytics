package com.flycar.analytics.service.dto;

public class RevenueDTO {
    private int rentingRevenue;
    private int totalRevenue;

    public RevenueDTO(int rentingRevenue, int totalRevenue) {
        this.rentingRevenue = rentingRevenue;
        this.totalRevenue = totalRevenue;
    }

    public int getRentingRevenue() {
        return rentingRevenue;
    }

    public void setRentingRevenue(int rentingRevenue) {
        this.rentingRevenue = rentingRevenue;
    }

    public int getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(int totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
