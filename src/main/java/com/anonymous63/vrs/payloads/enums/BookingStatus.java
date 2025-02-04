package com.anonymous63.vrs.payloads.enums;

public enum BookingStatus {
    PENDING(0),
    APPROVED(1),
    REJECTED(2);

    private final int value;

    private BookingStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
