package com.biblioteca.domain.book;

import com.biblioteca.domain.author.Author;
import com.biblioteca.domain.book.dto.BookUpdateDTO;
import com.biblioteca.domain.bookcase.Bookcase;
import com.biblioteca.domain.genre.Genre;
import org.springframework.stereotype.Component;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "Book")
@Table(name = "book")
@Component
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String title;

    @ManyToMany
    @JoinTable(name = "book_genders",
               joinColumns = @JoinColumn(name = "id_book"),
               inverseJoinColumns = @JoinColumn(name = "id_gender"))
    private List<Genre> genres;

    @ManyToMany
    @JoinTable(name = "bookcase_books",
               joinColumns = @JoinColumn(name = "id_book"),
               inverseJoinColumns = @JoinColumn(name = "id_bookcase"))
    private List<Bookcase> bookcases;

    @ManyToMany
    @JoinTable(name = "author_books",
               joinColumns = @JoinColumn(name = "id_book"),
               inverseJoinColumns = @JoinColumn(name = "id_author"))
    private List<Author> authors;

    @Column(nullable = false)
    private Integer units;

    @Column(nullable = false)
    private Integer availableUnits;
    public Book() {
    }

    public Book(UUID id,
                String title,
                List<Genre> genres,
                List<Bookcase> bookcases,
                List<Author> authors,
                Integer units,
                Integer availableUnits) {
        this.id = id;
        this.title = title;
        this.genres = genres;
        this.bookcases = bookcases;
        this.authors = authors;
        this.units = units;
        this.availableUnits = availableUnits;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Genre> getGenders() {
        return genres;
    }

    public void setGenders(List<Genre> genres) {
        this.genres = genres;
    }

    public List<Bookcase> getBookcases() {
        return bookcases;
    }

    public void setBookcases(List<Bookcase> bookcases) {
        this.bookcases = bookcases;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Integer getUnits() {
        return units;
    }

    public void setUnits(Integer units) {
        this.units = units;
    }

    public Integer getAvailableUnits() {
        return availableUnits;
    }

    public void setAvailableUnits(Integer availableUnits) {
        this.availableUnits = availableUnits;
    }

    public void update(BookUpdateDTO bookUpdateDTO){
        this.title = bookUpdateDTO.title();
        this.genres = bookUpdateDTO.genders()
                                    .stream()
                                    .map(genderDTO -> new Genre(genderDTO.id(), genderDTO.name())).toList();
        this.authors = bookUpdateDTO.authors()
                                    .stream()
                                    .map(authorDTO -> new Author(authorDTO.id(), authorDTO.name(), null)).toList();
    }

}
