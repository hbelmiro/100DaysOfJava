package com.thegreatapi.ahundreddaysofjava.day013;

import java.time.LocalDateTime;

public final class MySingletonClass {

    private final LocalDateTime creationDateTime;

    private MySingletonClass(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public static MySingletonClass getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private static final class InstanceHolder {
        static final MySingletonClass INSTANCE = new MySingletonClass(LocalDateTime.now());
    }
}
