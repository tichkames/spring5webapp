package hod.springframework.spring5webapp.model.recipe;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
public class Note {

    private String id;
    private Recipe recipe;
    private String recipeNote;
}
