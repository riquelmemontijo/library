package com.biblioteca.domain.borrow;

import com.biblioteca.domain.book.Book;
import com.biblioteca.domain.student.Student;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "borrow")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;
    private List<Book> books;
    private LocalDateTime borrowDate;
    private LocalDateTime dueDate;
    private BigDecimal penalty;

}
