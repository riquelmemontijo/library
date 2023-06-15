package com.biblioteca.domain.bookcase;

import com.biblioteca.domain.book.Book;
import com.biblioteca.domain.bookcase.dto.BookcaseUpdateDTO;
import com.biblioteca.domain.hall.Hall;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "Bookcase")
@Table(name = "bookcase")
public class Bookcase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private UUID id;
    private String alias;
    @ManyToMany(mappedBy = "bookcases")
    private List<Book> books;
    @ManyToOne
    @JoinColumn(name = "fk_hall", nullable = false)
    private Hall hall;

    public Bookcase() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public void update(BookcaseUpdateDTO dto){
        this.alias = dto.alias();
        this.hall = new Hall(dto.hall().id(), dto.hall().alias(), null);
    }

}
