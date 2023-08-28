package com.library.domain.student;

import com.library.domain.borrow.Borrow;
import com.library.domain.debit.StudentDebit;
import com.library.domain.student.dto.StudentUpdateDTO;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity(name = "Student")
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 20)
    private String phoneNumber;

    @OneToMany(mappedBy = "student")
    private List<Borrow> borrows;

    @OneToMany(mappedBy = "student")
    private List<StudentDebit> debits;

    public Student() {
    }

    public Student(UUID id,
                   String name,
                   LocalDate dateOfBirth,
                   String email,
                   String phoneNumber,
                   List<Borrow> borrows) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.borrows = borrows;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Borrow> getBorrows() {
        return borrows;
    }

    public void setBorrows(List<Borrow> borrows) {
        this.borrows = borrows;
    }

    public List<StudentDebit> getDebits() {
        return debits;
    }

    public void setDebits(List<StudentDebit> debits) {
        this.debits = debits;
    }

    public void update(StudentUpdateDTO dto){
       this.name = dto.name();
       this.dateOfBirth = dto.dateOfBirth();
       this.email = dto.email();
       this.phoneNumber = dto.phoneNumber();
    }
}
