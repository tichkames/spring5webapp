package hod.springframework.spring5webapp.repositories.recipe;

import hod.springframework.spring5webapp.model.recipe.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, String> {
    public Optional<UnitOfMeasure> findByDescription(String description);
}
