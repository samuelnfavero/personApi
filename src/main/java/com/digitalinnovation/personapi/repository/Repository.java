package com.digitalinnovation.personapi.repository;

import com.digitalinnovation.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Repository extends JpaRepository<Person,Long> {
}
