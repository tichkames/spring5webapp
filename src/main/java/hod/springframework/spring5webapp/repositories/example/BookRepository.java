package hod.springframework.spring5webapp.repositories.example;

import hod.springframework.spring5webapp.model.example.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
