package org.launchcode.tara.repository;

import org.launchcode.tara.model.Instance;
import org.launchcode.tara.model.InstanceLog;
import org.launchcode.tara.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InstanceRepository extends JpaRepository<Instance, Integer> {

    List<Instance> findAllByInstanceLog(InstanceLog instanceLog);

    List<Instance> findAllByUser(User user);
}
