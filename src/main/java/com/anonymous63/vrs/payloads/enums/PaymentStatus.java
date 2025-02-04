package com.anonymous63.vrs.payloads.enums;

public enum PaymentStatus {
    PENDING(0),
    APPROVED(1),
    REJECTED(2);

    private final int value;

    PaymentStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
