package com.biblioteca.domain.debit;

import com.biblioteca.domain.borrow.Borrow;
import com.biblioteca.domain.student.Student;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity(name = "StudentDebit")
@Table(name = "student_debit")
public class StudentDebit {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private BigDecimal value;

    @Column(nullable = false)
    private Boolean isPaid;

    @OneToOne
    @JoinColumn(name = "fk_borrow")
    private Borrow borrow;

    @ManyToOne
    @JoinColumn(name = "fk_student")
    private Student student;

    public StudentDebit() {
    }

    public StudentDebit(BigDecimal value, Boolean isPaid, Borrow borrow, Student student) {
        this.value = value;
        this.isPaid = isPaid;
        this.borrow = borrow;
        this.student = student;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
