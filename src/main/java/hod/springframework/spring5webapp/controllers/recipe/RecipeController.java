package hod.springframework.spring5webapp.controllers.recipe;

import hod.springframework.spring5webapp.model.recipe.Recipe;
import hod.springframework.spring5webapp.services.recipe.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Slf4j
@Controller
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping({"", "/", "/recipe"})
    private String getRecipePage(Model model){
        log.debug("RecipeController..");

        Set<Recipe> recipes = recipeService.getRecipes();
        model.addAttribute("recipes", recipes);
        return "recipe";
    }
}
