package com.slope.recall.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.slope.recall.data.Hello;
import java.util.List;
import java.util.Optional;


public interface HelloRepository extends CrudRepository<Hello, String> {

    List<Hello> findByWho(String who);

    List<Hello> findByWhoContainingIgnoreCase(String who);

    Optional<Hello> findById(String id);

    // @Query("SELECT COUNT(*) FROM Hello")
    // long countAll();
}
