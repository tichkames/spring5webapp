package hod.springframework.spring5webapp.services.recipe;

import hod.springframework.spring5webapp.model.recipe.Recipe;
import hod.springframework.spring5webapp.repositories.recipe.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public Recipe getRecipe(String description) {
        Optional<Recipe> recipe = recipeRepository.findByDescription(description);
        return recipe.isPresent() ? recipe.get() : null;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipes::add);
        return recipes;
    }
}
