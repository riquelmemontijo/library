package com.biblioteca.domain.debit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentDebitRepository extends JpaRepository<StudentDebit, UUID> {
    @Query("""
               SELECT d 
               FROM StudentDebit d 
               WHERE d.student = :idStudent
               AND d.isPaid = false;
           """)
    Optional<StudentDebit> findNotPaidDebitsByStudent();
}
