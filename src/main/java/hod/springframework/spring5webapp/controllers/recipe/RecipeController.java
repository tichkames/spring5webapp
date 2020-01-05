package hod.springframework.spring5webapp.controllers.recipe;

import hod.springframework.spring5webapp.model.recipe.Category;
import hod.springframework.spring5webapp.model.recipe.UnitOfMeasure;
import hod.springframework.spring5webapp.repositories.recipe.CategoryRepository;
import hod.springframework.spring5webapp.repositories.recipe.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class RecipeController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @RequestMapping({"", "/", "/recipe"})
    private String getRecipePage(){
        System.out.println("RecipeController..");

        Optional<Category> category = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println(String.format("category %s", category.get().getDescription()));
        System.out.println(String.format("uom %s", uom.get().getDescription()));

        return "recipe";
    }

}
