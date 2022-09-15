package com.redbee.mssecuritypractica.application.port.out;

import com.redbee.mssecuritypractica.domain.Seed;

import java.util.UUID;

public interface ConfirmationRepository {

    void save(Seed seed, UUID uuid);

    Seed findById(String id);
}
