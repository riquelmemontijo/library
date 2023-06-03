package com.biblioteca.domain.bookcase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookcaseRepository extends JpaRepository<Bookcase, UUID> {
}
