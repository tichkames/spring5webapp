package hod.springframework.spring5webapp.controllers.recipe;

import hod.springframework.spring5webapp.model.recipe.Recipe;
import hod.springframework.spring5webapp.services.recipe.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping({"", "/", "/recipe"})
    private String getRecipePage(Model model){
        System.out.println("RecipeController..");

        Set<Recipe> recipes = recipeService.getRecipes();
        model.addAttribute("recipes", recipes);
        return "recipe";
    }
}
