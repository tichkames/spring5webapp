package hod.springframework.spring5webapp.repositories.recipe.reactive;

import hod.springframework.spring5webapp.model.recipe.Recipe;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface RecipeReactiveRepository extends ReactiveMongoRepository<Recipe, String> {
    Mono<Recipe> findByDescription(String description);
}
