package com.biblioteca.domain.borrow;

import com.biblioteca.domain.book.Book;
import com.biblioteca.domain.student.Student;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "Borrow")
@Table(name = "borrow")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "pk_student")
    private Student student;
    @ManyToMany
    @JoinTable(name = "borrow_books",
               joinColumns = @JoinColumn(name = "id_borrow"),
               inverseJoinColumns = @JoinColumn(name = "id_book"))
    private List<Book> books;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime borrowDate;
    private LocalDateTime dueDate;
    private LocalDateTime returnDate;
    private Boolean isFinished;

    public Borrow() {
    }

    public Borrow(UUID id,
                  Student student,
                  List<Book> books,
                  LocalDateTime borrowDate,
                  LocalDateTime dueDate,
                  LocalDateTime returnDate,
                  Boolean isFinished) {
        this.id = id;
        this.student = student;
        this.books = books;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.isFinished = isFinished;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }
}
