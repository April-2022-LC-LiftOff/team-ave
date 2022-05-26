package org.launchcode.tara.repository;

import org.launchcode.tara.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {
    Boolean existsByName(String name);

    Tag getByName(String name);
}
