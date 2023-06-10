package com.biblioteca.domain.author;

import com.biblioteca.domain.book.Book;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "Author")
@Table(name = "author")
public class Author {


    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    @ManyToMany
    private List<Book> books;

}
