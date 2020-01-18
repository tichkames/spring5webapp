package hod.springframework.spring5webapp.services.recipe;

import hod.springframework.spring5webapp.commands.recipe.IngredientCommand;

public interface IngredientService {

    IngredientCommand findByRecipeIdAndIngredientId(String recipeId, String ingredientId);
    IngredientCommand saveIngredientCommand(IngredientCommand command);
    void deleteById(String recipeId, String idToDelete);
}
