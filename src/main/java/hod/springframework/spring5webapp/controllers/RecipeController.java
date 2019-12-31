package hod.springframework.spring5webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeController {

    @RequestMapping({"", "/", "/recipe"})
    private String getRecipePage(){
        System.out.println("RecipeController..123");
        return "recipe";
    }

}
