package hod.springframework.spring5webapp.commands.recipe;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NoteCommand {
    private Long id;
    private String recipeNote;
}