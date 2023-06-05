package com.biblioteca.domain.borrow;

import com.biblioteca.domain.book.Book;
import com.biblioteca.domain.book.BookMapper;
import com.biblioteca.domain.borrow.dto.BorrowUpdateDTO;
import com.biblioteca.domain.student.Student;
import com.biblioteca.domain.student.StudentMapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.math.BigDecimal;
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
    @JoinColumn(name = "id_student")
    private Student student;
    @ManyToMany
    @JoinTable(name = "borrow_books",
               joinColumns = @JoinColumn(name = "id_borrow"),
               inverseJoinColumns = @JoinColumn(name = "id_book"))
    private List<Book> books;
    private LocalDateTime borrowDate;
    private LocalDateTime dueDate;
    private BigDecimal penalty;

    @JsonIgnore
    @Autowired
    @Transient
    private StudentMapper studentMapper;

    @JsonIgnore
    @Autowired
    @Transient
    private BookMapper bookMapper;
    public Borrow() {
    }

    public Borrow(UUID id,
                  Student student,
                  List<Book> books,
                  LocalDateTime borrowDate,
                  LocalDateTime dueDate,
                  BigDecimal penalty) {
        this.id = id;
        this.student = student;
        this.books = books;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.penalty = penalty;
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

    public BigDecimal getPenalty() {
        return penalty;
    }

    public void setPenalty(BigDecimal penalty) {
        this.penalty = penalty;
    }

    public void update(BorrowUpdateDTO dto){
        if(dto.student() != null){
            this.student = studentMapper.studentInBorrowDTOtoStudent(dto.student());
        }
        if(!dto.books().isEmpty()){
            this.books = dto.books().stream().map(bookMapper::bookInBorrowDTOtoBook).toList();
        }
        if(dto.borrowDate() != null) {
            this.borrowDate = dto.borrowDate();
        }
    }
}
