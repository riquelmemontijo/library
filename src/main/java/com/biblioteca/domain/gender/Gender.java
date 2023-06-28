package com.biblioteca.domain.gender;

import com.biblioteca.domain.book.Book;
import com.biblioteca.domain.gender.dto.GenderUpdateDTO;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "Gender")
@Table(name = "gender")
public class Gender {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 20)
    private String name;

    @ManyToMany(mappedBy = "genders")
    private List<Book> books;

    public Gender() {
    }

    public Gender(UUID id, String name) {
        this.id = id;
        this.name = name;
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
