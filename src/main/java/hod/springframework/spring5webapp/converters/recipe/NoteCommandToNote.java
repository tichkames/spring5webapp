package hod.springframework.spring5webapp.converters.recipe;

import hod.springframework.spring5webapp.commands.recipe.NoteCommand;
import hod.springframework.spring5webapp.model.recipe.Note;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NoteCommandToNote implements Converter<NoteCommand, Note> {

    @Synchronized
    @Nullable
    @Override
    public Note convert(NoteCommand source) {
        if(source == null) {
            return null;
        }

        final Note notes = new Note();
        notes.setId(source.getId());
        notes.setRecipeNote(source.getRecipeNote());
        return notes;
    }
}
