package com.biblioteca.domain.gender;

import com.biblioteca.domain.book.Book;
import com.biblioteca.domain.gender.dto.GenderUpdateDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "gender")
public class Gender {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private UUID id;
    private String name;
    @ManyToMany(mappedBy = "genders")
    private List<Book> books;

    public Gender() {
    }

    public Gender(UUID id, String name, List<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
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

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void update(GenderUpdateDTO dto){
        this.name = dto.name();
    }
}
