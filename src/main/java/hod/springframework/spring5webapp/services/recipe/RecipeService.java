package hod.springframework.spring5webapp.services.recipe;

import hod.springframework.spring5webapp.model.recipe.Recipe;

import java.util.Set;

public interface RecipeService {
    Recipe getRecipe(String description);
    Set<Recipe> getRecipes();
}
