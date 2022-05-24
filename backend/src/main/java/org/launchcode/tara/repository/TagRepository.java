package org.launchcode.tara.repository;

import org.launchcode.tara.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Integer> {
    Boolean existsByName(String name);

    Tag getByName(String name);
}
