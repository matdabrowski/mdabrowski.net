package net.mdabrowski.springwebflux.repository;

import net.mdabrowski.springwebflux.model.Book;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book, String> {
}
