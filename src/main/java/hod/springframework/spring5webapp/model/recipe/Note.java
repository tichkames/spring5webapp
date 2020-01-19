package hod.springframework.spring5webapp.model.recipe;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Note {

    @Id
    private String id;
    private String recipeNote;
}
