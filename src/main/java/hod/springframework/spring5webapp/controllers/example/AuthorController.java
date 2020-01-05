package hod.springframework.spring5webapp.controllers.example;

import hod.springframework.spring5webapp.repositories.example.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository){
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/authors")
    public String getBooks(Model model){

        model.addAttribute("authors", authorRepository.findAll());
        return "authors";
    }
}
