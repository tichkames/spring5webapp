package hod.springframework.spring5webapp.repositories.example;

import hod.springframework.spring5webapp.model.example.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
