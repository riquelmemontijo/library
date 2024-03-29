package com.library.domain.hall;

import com.library.domain.bookcase.Bookcase;
import com.library.domain.hall.dto.HallUpdateDTO;

import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity(name = "Hall")
@Table(name = "hall")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String alias;

    @OneToMany(mappedBy = "hall")
    private List<Bookcase> bookcases;

    public Hall() {
    }

    public Hall(UUID id, String alias, List<Bookcase> bookcases) {
        this.id = id;
        this.alias = alias;
        this.bookcases = bookcases;
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

    public List<Bookcase> getBookcases() {
        return bookcases;
    }

    public void setBookcases(List<Bookcase> bookcases) {
        this.bookcases = bookcases;
    }

    public void update(HallUpdateDTO dto){
        this.alias = dto.alias();
    }
}
