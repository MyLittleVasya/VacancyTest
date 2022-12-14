package com.example.vacancy.repositories;

import com.example.vacancy.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<PersonEntity, Long> {
    PersonEntity findById(long id);

    PersonEntity findTopByOrderByIdDesc();
}
