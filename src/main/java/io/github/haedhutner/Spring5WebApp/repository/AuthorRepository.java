package io.github.haedhutner.Spring5WebApp.repository;

import io.github.haedhutner.Spring5WebApp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
