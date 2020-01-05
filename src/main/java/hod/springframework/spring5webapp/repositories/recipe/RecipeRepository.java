package hod.springframework.spring5webapp.repositories.recipe;

import hod.springframework.spring5webapp.model.recipe.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
}
