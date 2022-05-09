package com.flycar.analytics.service.dto;

public class SelfVSBorrowedDTO {

    private Float borrowed;
    private Float self;

    public SelfVSBorrowedDTO() {}

    public SelfVSBorrowedDTO(Float borrowed, Float self) {
        this.borrowed = borrowed;
        this.self = self;
    }

    public Float getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Float borrowed) {
        this.borrowed = borrowed;
    }

    public Float getSelf() {
        return self;
    }

    public void setSelf(Float self) {
        this.self = self;
    }

    @Override
    public String toString() {
        return "SelfVSBorrowedDTO{" + "borrowed=" + borrowed + ", self=" + self + '}';
    }
}
