package com.biblioteca.domain.debit;

import com.biblioteca.domain.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentDebitRepository extends JpaRepository<StudentDebit, UUID> {
    @Query("""
               SELECT d
               FROM StudentDebit d
               WHERE d.student = :student
               AND d.isPaid = false
           """)
    Optional<StudentDebit> findNotPaidDebitsByStudent(Student student);

    @Modifying
    @Query("""
              UPDATE StudentDebit sd
              SET sd.isPaid = TRUE
              WHERE sd = :studentDebit
           """)
    void paidDebit(StudentDebit studentDebit);
}
