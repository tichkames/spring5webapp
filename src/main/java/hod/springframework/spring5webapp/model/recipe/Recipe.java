package hod.springframework.spring5webapp.model.recipe;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString(exclude = {"note", "ingredients", "categories"})
@Document
public class Recipe {

    @Id
    private String id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Difficulty difficulty;
    private Byte[] image;
    private Note note;
    private Set<Ingredient> ingredients = new HashSet<>();
    private Set<Category> categories = new HashSet<>();

    public void setNote(Note note) {
        if(note != null) {
            this.note = note;
        }
    }

    public Recipe addIngredient(Ingredient ingredient){
        this.ingredients.add(ingredient);
        return this;
    }
}
