package hod.springframework.spring5webapp.bootstrap;

import hod.springframework.spring5webapp.model.example.Author;
import hod.springframework.spring5webapp.model.example.Book;
import hod.springframework.spring5webapp.model.example.Publisher;
import hod.springframework.spring5webapp.repositories.example.AuthorRepository;
import hod.springframework.spring5webapp.repositories.example.BookRepository;
import hod.springframework.spring5webapp.repositories.example.PublisherRepository;
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

    private void initData(){
        Author tich = new Author("Tich", "Kames");
        Publisher pub1 = new Publisher("Harper Collins", "Randpark Ridge");
        Book batman = new Book("Batman", "1234", pub1);
        tich.getBooks().add(batman);
        batman.getAuthors().add(tich);

        authorRepository.save(tich);
        publisherRepository.save(pub1);
        bookRepository.save(batman);

        Author josh = new Author("Josh", "K");
        Publisher pub2 = new Publisher("Worx", "Centurion");
        Book xmen = new Book("Xmen", "1234", pub2);
        josh.getBooks().add(xmen);
        xmen.getAuthors().add(josh);

        authorRepository.save(josh);
        publisherRepository.save(pub2);
        bookRepository.save(xmen);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
