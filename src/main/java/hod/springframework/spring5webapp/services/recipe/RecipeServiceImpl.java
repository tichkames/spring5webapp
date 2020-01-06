package hod.springframework.spring5webapp.services.recipe;

import hod.springframework.spring5webapp.model.recipe.Recipe;
import hod.springframework.spring5webapp.repositories.recipe.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Recipe getRecipe(String description) {
        Optional<Recipe> recipe = recipeRepository.findByDescription(description);
        return recipe.isPresent() ? recipe.get() : null;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("Inside getRecipes of RecipeServiceImpl");

        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }
}
