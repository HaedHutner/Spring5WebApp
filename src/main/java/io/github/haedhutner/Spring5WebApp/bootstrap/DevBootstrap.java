package io.github.haedhutner.Spring5WebApp.bootstrap;

import io.github.haedhutner.Spring5WebApp.model.Author;
import io.github.haedhutner.Spring5WebApp.model.Book;
import io.github.haedhutner.Spring5WebApp.repository.AuthorRepository;
import io.github.haedhutner.Spring5WebApp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final AuthorRepository authors;
    private final BookRepository books;

    @Autowired
    public DevBootstrap(AuthorRepository authors, BookRepository books) {
        this.authors = authors;
        this.books = books;
    }

    private void initData() {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book( "Domain Driver Design", "2415151", "Harper Collins" );
        ddd.getAuthors().add(eric);

        authors.save(eric);
        books.save(ddd);

        Author ned = new Author("Ned", "Stark");
        Book winter = new Book( "Winter Is Coming", "93256132", "Winterfell Publishing" );
        winter.getAuthors().add(ned);

        authors.save(ned);
        books.save(winter);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
