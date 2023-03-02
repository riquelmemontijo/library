package com.biblioteca.domain.gender;

import com.biblioteca.domain.book.Book;
import com.biblioteca.domain.gender.dto.GenderFormDTO;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "gender")
public class Gender {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(nullable = false, unique = true)
    private UUID id;
    private String name;
    @ManyToMany(mappedBy = "genders")
    private List<Book> books;

    public Gender() {
    }

    public Gender(GenderFormDTO genterDTO) {
        this.name = genterDTO.name();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }
}
