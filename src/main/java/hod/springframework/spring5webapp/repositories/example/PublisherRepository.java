package hod.springframework.spring5webapp.repositories.example;

import hod.springframework.spring5webapp.model.example.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
