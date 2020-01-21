package hod.springframework.spring5webapp.services.recipe;

import hod.springframework.spring5webapp.commands.recipe.RecipeCommand;
import hod.springframework.spring5webapp.model.recipe.Recipe;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RecipeService {
    Flux<Recipe> getRecipes();
    Mono<Recipe> findById(String id);
    Mono<RecipeCommand> saveRecipeCommand(RecipeCommand command);
    Mono<RecipeCommand> findCommandById(String l);
    Mono<Void> deleteById(String idToDelete);
}
