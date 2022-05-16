package org.launchcode.tara.repository;

import org.launchcode.tara.model.InstanceLog;
import org.launchcode.tara.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InstanceLogRepository extends JpaRepository<InstanceLog, Integer> {

    public InstanceLog findInstanceByUser(User user);

    void deleteInstanceById(int id);

    Optional<InstanceLog> findInstanceLogById(int id);
}
