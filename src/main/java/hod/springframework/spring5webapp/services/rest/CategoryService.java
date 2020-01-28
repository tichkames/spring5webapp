package hod.springframework.spring5webapp.services.rest;

import hod.springframework.spring5webapp.api.v1.model.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> getAllCategories();

    CategoryDTO getCategoryByName(String name);
}
