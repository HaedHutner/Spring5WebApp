package io.github.haedhutner.Spring5WebApp.bootstrap;

import io.github.haedhutner.Spring5WebApp.model.Author;
import io.github.haedhutner.Spring5WebApp.model.Book;
import io.github.haedhutner.Spring5WebApp.model.Publisher;
import io.github.haedhutner.Spring5WebApp.repository.AuthorRepository;
import io.github.haedhutner.Spring5WebApp.repository.BookRepository;
import io.github.haedhutner.Spring5WebApp.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap {

    private final AuthorRepository authors;
    private final BookRepository books;
    private final PublisherRepository publishers;

    @Autowired
    public DevBootstrap(AuthorRepository authors, BookRepository books, PublisherRepository publishers) {
        this.authors = authors;
        this.books = books;
        this.publishers = publishers;
    }

    @EventListener
    public void onEvent ( ContextRefreshedEvent event ) {
        System.out.println( "Detected event @ " + event.getTimestamp() );
        initData();
    }

    private void initData() {

        Publisher winterPublishing = new Publisher( "Winter Publishing Co. Ltd.", "Magic Street 123" );
        publishers.save(winterPublishing);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book( "Domain Driven Design", "2415151", winterPublishing );
        ddd.getAuthors().add(eric);

        authors.save(eric);
        books.save(ddd);

        Author ned = new Author("Ned", "Stark");
        Book winter = new Book( "Winter Is Coming", "93256132", winterPublishing );
        winter.getAuthors().add(ned);

        authors.save(ned);
        books.save(winter);

    }

    public void works() {
        System.out.println("DevBootstrap Works.");
    }
}
