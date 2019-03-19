package net.mdabrowski.springwebflux;

import net.mdabrowski.springwebflux.controller.BookHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@Configuration
public class BookConfiguration {

    @Bean
    public RouterFunction<ServerResponse> booksRoute(BookHandler bookHandler) {
        return RouterFunctions.route(GET("/books/fun"), bookHandler::getBooks);
    }
}
