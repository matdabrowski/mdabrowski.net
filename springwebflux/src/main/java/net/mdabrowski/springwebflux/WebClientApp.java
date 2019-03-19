package net.mdabrowski.springwebflux;

import net.mdabrowski.springwebflux.model.Book;
import org.springframework.web.reactive.function.client.WebClient;

public class WebClientApp {

    public static void main(String[] args) {
        WebClient.create("http://localhost:8080")
                .get()
                .uri("/books")
                .retrieve()
                .bodyToFlux(Book.class)
                .doOnNext(x -> System.out.println("#: " + x))
                .blockLast();
    }
}
