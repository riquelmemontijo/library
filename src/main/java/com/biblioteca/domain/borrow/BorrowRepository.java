package com.biblioteca.domain.borrow;

import com.biblioteca.tasks.dto.NotifyStudentBorrowExpiration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, UUID> {

    @Query("""
              SELECT NEW
              com.biblioteca.tasks.dto.NotifyStudentBorrowExpiration(s.name, s.email, b.dueDate)
              FROM Borrow b
              INNER JOIN Student s ON s.id = b.student
              WHERE b.dueDate  = current_date + 1
           """)
    Optional<List<NotifyStudentBorrowExpiration>> findBorrowDueToday();

}
