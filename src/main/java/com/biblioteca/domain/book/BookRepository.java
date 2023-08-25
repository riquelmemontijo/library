package com.biblioteca.domain.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {
    @Modifying
    @Query("""
              UPDATE Book b
              SET b.availableUnits = b.availableUnits - 1
              WHERE b IN (:books)
           """)
    void decreaseStock(List<Book> books);

    @Modifying
    @Query("""
              UPDATE Book b
              SET b.availableUnits = b.availableUnits + 1
              WHERE b IN (:books)
           """)
    void addStock(List<Book> books);
}
