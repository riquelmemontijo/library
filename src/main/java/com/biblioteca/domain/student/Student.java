package com.biblioteca.domain.student;

import com.biblioteca.domain.borrow.Borrow;
import com.biblioteca.domain.student.dto.StudentUpdateDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity(name = "Student")
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private UUID id;
    private String name;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
    @OneToMany(mappedBy = "student")
    private List<Borrow> borrows;

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

    public void update(StudentUpdateDTO dto){
        if(!dto.name().isBlank()){
           this.name = dto.name();
        }
        if(dto.dateOfBirth() != null){
            this.dateOfBirth = dto.dateOfBirth();
        }
        if(!dto.email().isBlank()){
            this.email = dto.email();
        }
        if(!dto.phoneNumber().isBlank()){
            this.phoneNumber = dto.phoneNumber();
        }
    }
}
