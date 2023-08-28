package com.library.domain.bookcase;

import com.library.domain.book.Book;
import com.library.domain.bookcase.dto.BookcaseUpdateDTO;
import com.library.domain.hall.Hall;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "Bookcase")
@Table(name = "bookcase")
public class Bookcase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 100)
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
