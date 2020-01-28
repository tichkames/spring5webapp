package hod.springframework.spring5webapp.repositories.rest;

import hod.springframework.spring5webapp.model.rest.CategoryRest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepositoryRest extends JpaRepository<CategoryRest, Long> {
}