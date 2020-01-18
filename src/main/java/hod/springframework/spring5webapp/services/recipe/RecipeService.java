package hod.springframework.spring5webapp.services.recipe;

import hod.springframework.spring5webapp.commands.recipe.RecipeCommand;
import hod.springframework.spring5webapp.model.recipe.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(String id);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
    RecipeCommand findCommandById(String l);
    void deleteById(String idToDelete);
}
