package com.library.domain.author;

import com.library.domain.author.dto.AuthorUpdateDTO;
import com.library.domain.book.Book;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "Author")
@Table(name = "author")
public class Author {


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 150)
    private String name;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    public Author() {
    }

    public Author(UUID id, String name, List<Book> books) {
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

    public void update(AuthorUpdateDTO dto){
        this.name = dto.name();
    }
}
