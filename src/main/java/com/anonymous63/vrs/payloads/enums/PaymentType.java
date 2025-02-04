package com.anonymous63.vrs.payloads.enums;

public enum PaymentType {
    CREDIT(1),
    DEBIT(2),
    NET_BANKING(3),
    UPI(4);

    private final int value;

    PaymentType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
