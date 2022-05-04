package org.launchcode.tara.repository;

import org.launchcode.tara.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUserId(int id);

}
