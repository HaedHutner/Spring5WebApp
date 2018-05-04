package io.github.haedhutner.Spring5WebApp.repository;

import io.github.haedhutner.Spring5WebApp.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
