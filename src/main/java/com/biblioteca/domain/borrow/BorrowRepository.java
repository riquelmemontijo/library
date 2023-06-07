package com.biblioteca.domain.borrow;

import com.biblioteca.domain.student.Student;
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
              WHERE b.student = :student
              AND (CURRENT_DATE - b.borrowDate) > 7
           """)
    Optional<Borrow> findBorrowWithDelayByStudent(Student student);

}
