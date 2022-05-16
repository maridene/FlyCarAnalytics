package com.flycar.analytics.service.dto;

import java.math.BigInteger;

public class BookingsVehicleCategoryDTO {
    private int vehicleCategoryId;
    private BigInteger count;
    private String code;
    private String name;

    public BookingsVehicleCategoryDTO() {

    }

    public BookingsVehicleCategoryDTO(int vehicleCategoryId, BigInteger count, String code, String name) {
        this.vehicleCategoryId = vehicleCategoryId;
        this.count = count;
        this.code = code;
        this.name = name;
    }

    public int getVehicleCategoryId() {
        return vehicleCategoryId;
    }

    public void setVehicleCategoryId(int vehicleCategoryId) {
        this.vehicleCategoryId = vehicleCategoryId;
    }

    public BigInteger getCount() {
        return count;
    }

    public void setCount(BigInteger count) {
        this.count = count;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
