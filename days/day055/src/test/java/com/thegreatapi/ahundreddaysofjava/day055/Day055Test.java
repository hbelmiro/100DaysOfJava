package com.thegreatapi.ahundreddaysofjava.day055;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day055Test {

    @Test
    void testEquals() {
        Day055 obj1 = new Day055("thegreatapi.com", 42);
        Day055 obj2 = new Day055("thegreatapi.com", 42);

        // Intead of using JUnit assertions, like this:
        assertEquals(obj1.hashCode(), obj2.hashCode());

        // Use AssertJ, like this:
        assertThat(obj1).hasSameHashCodeAs(obj2);
    }
}