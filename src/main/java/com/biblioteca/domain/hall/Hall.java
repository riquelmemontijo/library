package com.biblioteca.domain.hall;

import com.biblioteca.domain.bookcase.Bookcase;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "hall")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private UUID id;
    private String alias;
    @OneToMany(mappedBy = "hall")
    private List<Bookcase> bookcases;

}
