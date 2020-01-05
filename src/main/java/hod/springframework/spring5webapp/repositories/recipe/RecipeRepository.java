package hod.springframework.spring5webapp.repositories.recipe;

import hod.springframework.spring5webapp.model.recipe.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    Optional<Recipe> findByDescription(String description);
}
