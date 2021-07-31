package com.thegreatapi.ahundreddaysofjava.day073.paymentprocessor;

import java.math.BigDecimal;

public final record Payment(String id, BigDecimal value) {
}