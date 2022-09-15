package com.redbee.mssecuritypractica.application.port.out;

import com.redbee.mssecuritypractica.domain.Seed;

import java.util.UUID;

public interface NotificationRepository {

    void notify(Seed seed, UUID notificationId);
}
