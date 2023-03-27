package com.biblioteca.domain.book;

import com.biblioteca.domain.book.dto.BookUpdateDTO;
import com.biblioteca.domain.gender.Gender;
import com.biblioteca.domain.gender.GenderMapper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private UUID id;
    private String title;
    @ManyToMany
    @JoinTable(name = "book_genders",
               joinColumns = @JoinColumn(name = "id_book"),
               inverseJoinColumns = @JoinColumn(name = "id_gender"))
    private List<Gender> genders;
    private String author;
    private Integer units;
    private Integer availableUnits;

    @Autowired
    @JsonIgnore
    @Transient
    private GenderMapper genderMapper;

    public Book() {
    }

    public Book(UUID id,
                String title,
                List<Gender> genders,
                String author,
                Integer units,
                Integer availableUnits) {
        this.id = id;
        this.title = title;
        this.genders = genders;
        this.author = author;
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

    public List<Gender> getGenders() {
        return genders;
    }

    public void setGenders(List<Gender> genders) {
        this.genders = genders;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public GenderMapper getGenderMapper() {
        return genderMapper;
    }

    public void setGenderMapper(GenderMapper genderMapper) {
        this.genderMapper = genderMapper;
    }

    public void update(BookUpdateDTO bookUpdateDTO){

        this.title = bookUpdateDTO.title();
        this.genders = bookUpdateDTO.genders()
                                    .stream()
                                    .map(genderMapper::genderInBookDTOtoGender)
                                    .toList();
        this.author = bookUpdateDTO.author();
    }

}
