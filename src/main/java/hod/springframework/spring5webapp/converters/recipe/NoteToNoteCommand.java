package hod.springframework.spring5webapp.converters.recipe;

import hod.springframework.spring5webapp.commands.recipe.NoteCommand;
import hod.springframework.spring5webapp.model.recipe.Note;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class NoteToNoteCommand implements Converter<Note, NoteCommand> {

    @Synchronized
    @Nullable
    @Override
    public NoteCommand convert(Note source) {
        if (source == null) {
            return null;
        }

        final NoteCommand notesCommand = new NoteCommand();
        notesCommand.setId(source.getId());
        notesCommand.setRecipeNote(source.getRecipeNote());
        return notesCommand;
    }
}
