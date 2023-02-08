package com.biblioteca.domain.book;

import com.biblioteca.domain.gender.Gender;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private UUID id;
    private String title;
    @ManyToMany
    @JoinTable(name = "book_genders",
               joinColumns = @JoinColumn(name = "id_book"),
               inverseJoinColumns = @JoinColumn(name = "id_gender"))
    private List<Gender> genders;
    private String autor;
    private Integer units;
    private Integer availableUnits;

}
