package hod.springframework.spring5webapp.repositories.recipe;

import hod.springframework.spring5webapp.model.recipe.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, String> {
    Optional<Category> findByDescription(String description);
}
