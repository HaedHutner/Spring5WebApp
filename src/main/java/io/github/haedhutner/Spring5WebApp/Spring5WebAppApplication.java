package io.github.haedhutner.Spring5WebApp;

import io.github.haedhutner.Spring5WebApp.bootstrap.DevBootstrap;
import io.github.haedhutner.Spring5WebApp.controller.PublisherController;
import io.github.haedhutner.Spring5WebApp.model.Publisher;
import io.github.haedhutner.Spring5WebApp.repository.PublisherRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Spring5WebAppApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Spring5WebAppApplication.class, args);

        PublisherRepository repository = context.getBean(PublisherRepository.class);
        PublisherController controller = (PublisherController) context.getBean("publisherController");
        DevBootstrap bootstrap = context.getBean(DevBootstrap.class);

        // no work
        //Publisher publisher = context.getBean(Publisher.class);
        //if ( publisher != null ) {
        //    System.out.println( "Found publisher?!?!?!: " + publisher.toString() );
        //}

        if ( bootstrap != null ) {
            bootstrap.works();
        }

        // test controller: works
        controller.print();

        // test repository: works
        if ( repository != null ) {
            for (Publisher pub : repository.findAll()) {
                System.out.println("Found it: " + pub.toString());
            }
        }

    }
}
