package hod.springframework.spring5webapp.model.recipe;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryTest {

    Category category;

    @BeforeEach
    public void setUp(){
        category = new Category();
    }

    @Test
    void getDescription() {
    }

    @Test
    void getRecipes() {
    }

    @Test
    void getId() {
        String idValue = "4L";
        category.setId(idValue);
        assertEquals(idValue, category.getId());
    }
}