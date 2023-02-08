package com.biblioteca.domain.gender;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GenderRepository extends JpaRepository<Gender, UUID> {
}
