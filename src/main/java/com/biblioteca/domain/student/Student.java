package com.biblioteca.domain.student;

import com.biblioteca.domain.borrow.Borrow;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
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

}
