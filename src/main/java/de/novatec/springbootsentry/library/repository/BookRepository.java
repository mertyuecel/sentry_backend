package de.novatec.springbootsentry.library.repository;


import de.novatec.springbootsentry.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
