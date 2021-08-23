package com.thegreatapi.ahundreddaysofjava.day096;

import java.math.BigDecimal;
import java.util.List;

public record Order(String customer, List<String> products, BigDecimal totalValue) {
}