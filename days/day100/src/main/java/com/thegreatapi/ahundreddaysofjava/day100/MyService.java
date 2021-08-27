package com.thegreatapi.ahundreddaysofjava.day100;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Map;
import java.util.Optional;

public class MyService {

    private final Map<Integer, String> map;

    public MyService(Map<Integer, String> map) {
        this.map = map;
    }

    @Nonnull
    public Optional<String> getWithOptional(Integer index) {
        return Optional.ofNullable(map.get(index));
    }

    @Nullable
    public String getNullable(Integer index) {
        return map.get(index);
    }
}
