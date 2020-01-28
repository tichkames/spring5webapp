package hod.springframework.spring5webapp.services.rest;

import hod.springframework.spring5webapp.api.v1.mapper.CategoryMapper;
import hod.springframework.spring5webapp.api.v1.model.CategoryDTO;
import hod.springframework.spring5webapp.repositories.rest.CategoryRepositoryRest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryMapper categoryMapper;
    private final CategoryRepositoryRest categoryRepositoryRest;

    public CategoryServiceImpl(CategoryMapper categoryMapper, CategoryRepositoryRest categoryRepositoryRest) {
        this.categoryMapper = categoryMapper;
        this.categoryRepositoryRest = categoryRepositoryRest;
    }

    @Override
    public List<CategoryDTO> getAllCategories() {

        return categoryRepositoryRest.findAll()
                .stream()
                .map(categoryMapper::categoryToCategoryDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        return categoryMapper.categoryToCategoryDTO(categoryRepositoryRest.findByName(name));
    }
}
