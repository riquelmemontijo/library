package com.biblioteca.domain.bookcase;

import com.biblioteca.domain.book.Book;
import com.biblioteca.domain.hall.Hall;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "bookcase")
public class Bookcase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private UUID id;
    private String alias;
    @ManyToMany
    @JoinTable(name = "bookcase_books",
               joinColumns = @JoinColumn(name = "id_bookcase"),
               inverseJoinColumns = @JoinColumn(name = "id_book"))
    private List<Book> books;
    @ManyToOne
    @JoinColumn(name = "id_hall", nullable = false)
    private Hall hall;

}
