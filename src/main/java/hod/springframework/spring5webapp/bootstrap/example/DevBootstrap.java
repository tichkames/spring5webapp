package hod.springframework.spring5webapp.bootstrap.example;

import hod.springframework.spring5webapp.model.recipe.Category;
import hod.springframework.spring5webapp.model.recipe.Ingredient;
import hod.springframework.spring5webapp.model.recipe.Note;
import hod.springframework.spring5webapp.model.recipe.Recipe;
import hod.springframework.spring5webapp.repositories.recipe.CategoryRepository;
import hod.springframework.spring5webapp.repositories.recipe.RecipeRepository;
import hod.springframework.spring5webapp.repositories.recipe.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private void initRecipeData(){

        Note note1 = new Note();
        note1.setRecipeNote("note1");

        Category category1 = new Category();
        category1.setDescription("category1 description");

        categoryRepository.save(category1);

        Recipe recipe = new Recipe();

        Ingredient ingredient1 = new Ingredient("ingredient1 description",
                BigDecimal.valueOf(500), unitOfMeasureRepository.findByDescription("Teaspoon").get());

        Set<Ingredient> ingredients = new HashSet<>();
        ingredients.add(ingredient1);

        Set<Category> categories = new HashSet<>();
        categories.add(category1);

        recipe.setDescription("recipe description");
        recipe.setPrepTime(10);
        recipe.setCookTime(20);
        recipe.setServings(5);
        recipe.setSource("recipe source");
        recipe.setUrl("recipe url");
        recipe.setDirections("recipe directions");
        recipe.setImage(null);
        recipe.setNote(note1);
        recipe.setIngredients(ingredients);
        recipe.setCategories(categories);

        recipeRepository.save(recipe);
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initRecipeData();
    }
}
