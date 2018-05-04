package io.github.haedhutner.Spring5WebApp.repository;

import io.github.haedhutner.Spring5WebApp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
