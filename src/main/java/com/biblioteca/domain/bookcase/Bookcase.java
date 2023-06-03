package com.biblioteca.domain.bookcase;

import com.biblioteca.domain.book.Book;
import com.biblioteca.domain.bookcase.dto.BookcaseUpdateDTO;
import com.biblioteca.domain.hall.Hall;
import com.biblioteca.domain.hall.HallMapper;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.beans.factory.annotation.Autowired;

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
    @ManyToMany(mappedBy = "bookcases")
    private List<Book> books;
    @ManyToOne
    @JoinColumn(name = "pk_hall", nullable = false)
    private Hall hall;

    @JsonIgnore
    @Autowired
    @Transient
    private HallMapper hallMapper;

    public Bookcase() {
    }

    public Bookcase(UUID id, String alias, List<Book> books, Hall hall) {
        this.id = id;
        this.alias = alias;
        this.books = books;
        this.hall = hall;
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

    public HallMapper getHallMapper() {
        return hallMapper;
    }

    public void setHallMapper(HallMapper hallMapper) {
        this.hallMapper = hallMapper;
    }

    public void update(BookcaseUpdateDTO dto){
        if(!dto.alias().isBlank()){
            this.alias = dto.alias();
        }
        if(dto.hall() != null){
            this.hall = hallMapper.hallInBookcaseDTOtoHall(dto.hall());
        }
    }

}
