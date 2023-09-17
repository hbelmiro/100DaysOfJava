package com.thegreatapi.ahundreddaysofjava.day002;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

class Day002Test {

    @Test
    void formatDate() {
        DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        LocalDateTime currentDateTime = LocalDateTime.of(2020, 1, 31, 20, 35, 45);

        assertThat(currentDateTime.format(FORMATTER))
                .isEqualTo("31/01/2020 20:35:45");
    }
}
