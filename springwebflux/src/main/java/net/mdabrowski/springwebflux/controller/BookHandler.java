package net.mdabrowski.springwebflux.controller;

import net.mdabrowski.springwebflux.model.Book;
import net.mdabrowski.springwebflux.repository.BookRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Component
public class BookHandler {

    private final BookRepository bookRepository;

    public BookHandler(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Mono<ServerResponse> getBooks(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_STREAM_JSON)
                .body(bookRepository.findAll().delayElements(Duration.ofSeconds(5)), Book.class);
    }
}
