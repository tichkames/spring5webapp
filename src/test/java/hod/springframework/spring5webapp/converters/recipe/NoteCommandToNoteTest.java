package hod.springframework.spring5webapp.converters.recipe;

import hod.springframework.spring5webapp.commands.recipe.NoteCommand;
import hod.springframework.spring5webapp.model.recipe.Note;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NoteCommandToNoteTest {

    public static final Long ID_VALUE = new Long(1L);
    public static final String RECIPE_NOTE = "Note";
    NoteCommandToNote converter;

    @BeforeEach
    public void setUp() throws Exception {
        converter = new NoteCommandToNote();

    }

    @Test
    public void testNullParameter() throws Exception {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() throws Exception {
        assertNotNull(converter.convert(new NoteCommand()));
    }

    @Test
    public void convert() throws Exception {
        //given
        NoteCommand notesCommand = new NoteCommand();
        notesCommand.setId(ID_VALUE);
        notesCommand.setRecipeNote(RECIPE_NOTE);

        //when
        Note notes = converter.convert(notesCommand);

        //then
        assertNotNull(notes);
        assertEquals(ID_VALUE, notes.getId());
        assertEquals(RECIPE_NOTE, notes.getRecipeNote());
    }

}