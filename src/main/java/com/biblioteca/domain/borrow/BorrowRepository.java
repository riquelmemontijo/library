package com.biblioteca.domain.borrow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, UUID> {
    @Query("""
              SELECT b 
              FROM Borrow b 
              WHERE b.student = :idStudent 
              AND (b.borrowDate - now()) > 7
           """)
    Optional<Borrow> findBorrowWithDelayByStudent(UUID idStudent);

}
