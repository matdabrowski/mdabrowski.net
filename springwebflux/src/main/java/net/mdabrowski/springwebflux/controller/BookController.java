package net.mdabrowski.springwebflux.controller;

import net.mdabrowski.springwebflux.model.Book;
import net.mdabrowski.springwebflux.repository.BookRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(value = "/books", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Book> getBooks() {
        return bookRepository.findAll()
                .delayElements(Duration.ofSeconds(5));
    }
}
