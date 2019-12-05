package hod.springframework.spring5webapp.bootstrap;

import hod.springframework.spring5webapp.model.Author;
import hod.springframework.spring5webapp.model.Book;
import hod.springframework.spring5webapp.repositories.AuthorRepository;
import hod.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    private void initData(){
        Author tich = new Author("Tich", "Kames");
        Book batman = new Book("Batman", "1234", "Harper Collins");
        tich.getBooks().add(batman);
        batman.getAuthors().add(tich);

        authorRepository.save(tich);
        bookRepository.save(batman);

        Author josh = new Author("Josh", "K");
        Book xmen = new Book("Xmen", "1234", "Worx");
        josh.getBooks().add(xmen);
        xmen.getAuthors().add(josh);

        authorRepository.save(josh);
        bookRepository.save(xmen);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}
