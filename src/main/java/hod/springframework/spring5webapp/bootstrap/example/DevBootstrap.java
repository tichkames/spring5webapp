package hod.springframework.spring5webapp.bootstrap.example;

import hod.springframework.spring5webapp.model.example.Author;
import hod.springframework.spring5webapp.model.example.Book;
import hod.springframework.spring5webapp.model.example.Publisher;
import hod.springframework.spring5webapp.model.recipe.Category;
import hod.springframework.spring5webapp.model.recipe.Ingredient;
import hod.springframework.spring5webapp.model.recipe.Note;
import hod.springframework.spring5webapp.model.recipe.Recipe;
import hod.springframework.spring5webapp.repositories.example.AuthorRepository;
import hod.springframework.spring5webapp.repositories.example.BookRepository;
import hod.springframework.spring5webapp.repositories.example.PublisherRepository;
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

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    private void initRecipeData(){

        Note note1 = new Note();
        note1.setRecipeNote("note1");

        Category category1 = new Category();
        category1.setDescription("category1 description");

        categoryRepository.save(category1);

        Recipe recipe = new Recipe();

        Ingredient ingredient1 = new Ingredient("ingredient1 description",
                BigDecimal.valueOf(500), unitOfMeasureRepository.findByDescription("Teaspoon").get(), recipe);

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

    private void initExampleData(){
        Author tich = new Author("Tich", "Kames");
        Publisher pub1 = new Publisher("Harper Collins", "Randpark Ridge");
        Book batman = new Book("Batman", "1234", pub1);
        tich.getBooks().add(batman);
        batman.getAuthors().add(tich);

        authorRepository.save(tich);
        publisherRepository.save(pub1);
        bookRepository.save(batman);

        Author josh = new Author("Josh", "K");
        Publisher pub2 = new Publisher("Worx", "Centurion");
        Book xmen = new Book("Xmen", "1234", pub2);
        josh.getBooks().add(xmen);
        xmen.getAuthors().add(josh);

        authorRepository.save(josh);
        publisherRepository.save(pub2);
        bookRepository.save(xmen);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initExampleData();
    }
}
