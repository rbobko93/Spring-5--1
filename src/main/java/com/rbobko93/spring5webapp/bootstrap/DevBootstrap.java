package com.rbobko93.spring5webapp.bootstrap;

import com.rbobko93.spring5webapp.model.Author;
import com.rbobko93.spring5webapp.model.Book;
import com.rbobko93.spring5webapp.model.Publisher;
import com.rbobko93.spring5webapp.repositories.AuthorRepository;
import com.rbobko93.spring5webapp.repositories.BookRepository;
import com.rbobko93.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        //Eric
        Author eric = new Author("Eric", "Evans");
        Publisher ericPublisher = new Publisher("Harher Collins", "123 Green St");
        Book ddd = new Book("Domain Driven Design", "1234", ericPublisher);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(ericPublisher);
        bookRepository.save(ddd);

        //Rod
        Author rod = new Author("Rod", "Johnson");
        Publisher rodPublisher = new Publisher("Worx", "1542 Adress Blvd");
        Book noEJB = new Book("J2EE Development without EJB", "23444", rodPublisher);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        publisherRepository.save(rodPublisher);
        bookRepository.save(noEJB);
    }
}
