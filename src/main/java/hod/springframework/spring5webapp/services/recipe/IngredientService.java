package hod.springframework.spring5webapp.services.recipe;

import hod.springframework.spring5webapp.commands.recipe.IngredientCommand;
import reactor.core.publisher.Mono;

public interface IngredientService {

    Mono<IngredientCommand> findByRecipeIdAndIngredientId(String recipeId, String ingredientId);
    Mono<IngredientCommand> saveIngredientCommand(IngredientCommand command);
    Mono<Void> deleteById(String recipeId, String idToDelete);
}
