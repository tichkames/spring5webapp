package hod.springframework.spring5webapp.repositories.recipe.reactive;

import hod.springframework.spring5webapp.model.recipe.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CategoryReactiveRepository extends ReactiveMongoRepository<Category, String> {
    Mono<Category> findByDescription(String description);
}
