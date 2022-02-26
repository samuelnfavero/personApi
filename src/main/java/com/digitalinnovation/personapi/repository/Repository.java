package com.digitalinnovation.personapi.repository;

import com.digitalinnovation.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Person,Long> {
}
