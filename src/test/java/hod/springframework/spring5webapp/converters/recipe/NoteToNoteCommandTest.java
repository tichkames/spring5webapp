package hod.springframework.spring5webapp.converters.recipe;

import hod.springframework.spring5webapp.commands.recipe.NoteCommand;
import hod.springframework.spring5webapp.model.recipe.Note;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NoteToNoteCommandTest {

    public static final String ID_VALUE = "1L";
    public static final String RECIPE_NOTES = "Notes";
    NoteToNoteCommand converter;

    @BeforeEach
    public void setUp() throws Exception {
        converter = new NoteToNoteCommand();
    }

    @Test
    public void convert() throws Exception {
        //given
        Note note = new Note();
        note.setId(ID_VALUE);
        note.setRecipeNote(RECIPE_NOTES);

        //when
        NoteCommand noteCommand = converter.convert(note);

        //then
        assertEquals(ID_VALUE, noteCommand.getId());
        assertEquals(RECIPE_NOTES, noteCommand.getRecipeNote());
    }

    @Test
    public void testNull() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new Note()));
    }
}