package hod.springframework.spring5webapp.controllers.recipe;

import hod.springframework.spring5webapp.model.recipe.Recipe;
import hod.springframework.spring5webapp.services.recipe.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Slf4j
@Controller
public class RecipeController {

    private RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/recipe"})
    public String getRecipePage(Model model){
        log.debug("getRecipePage..");

        Set<Recipe> recipes = recipeService.getRecipes();
        model.addAttribute("recipes", recipes);
        return "recipe";
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model){
        log.debug("showById..");

        Recipe recipe = recipeService.findById(Long.valueOf(id));
        log.debug("Recipe: " + recipe);
        model.addAttribute("recipe", recipe);

        return "recipe/show";
    }
}
