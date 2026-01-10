package com.example.olympiad.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.example.olympiad.model.Registration;

import org.springframework.stereotype.Repository;

@Repository
public class RegistrationRepository {
    private final Map<UUID, Registration> store = new ConcurrentHashMap<>();

    public Registration save(Registration r) {
        store.put(r.getId(), r);
        return r;
    }

    public List<Registration> findAll() {
        return Collections.unmodifiableList(new ArrayList<>(store.values()));
    }

    public void clear() { store.clear(); }
}
