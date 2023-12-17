package de.novatec.springbootsentry.library.rest;

import de.novatec.springbootsentry.common.exceptions.CustomException;
import de.novatec.springbootsentry.library.model.Book;
import de.novatec.springbootsentry.library.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {
    private final BookRepository bookRepository;

    public LibraryController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @PostMapping("/addBook")
    public Book addBook(@RequestBody Book book) throws CustomException {
        if(book.getAuthor().isEmpty() || book.getTitle().isEmpty()){
            throw new CustomException("Title or Author Name is Missing!", 400);
        }

    return bookRepository.save(book);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
       return bookRepository.findAll();
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @PutMapping("/updateBook/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        if (bookRepository.existsById(id)) {
            updatedBook.setId(id);
            return bookRepository.save(updatedBook);
        } else {
            return null;
        }
    }

    @DeleteMapping("/deleteBook/{id}")
    public void deleteBook(@PathVariable Long id) throws CustomException {
        if (bookRepository.existsById(id)) {
            bookRepository.deleteById(id);
        } else {
            throw new CustomException("Could not find the book!!!", 404);
        }
    }
}