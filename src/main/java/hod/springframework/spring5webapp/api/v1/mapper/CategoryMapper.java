package hod.springframework.spring5webapp.api.v1.mapper;

import hod.springframework.spring5webapp.api.v1.model.CategoryDTO;
import hod.springframework.spring5webapp.model.rest.CategoryRest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDTO categoryToCategoryDTO(CategoryRest category);
}
