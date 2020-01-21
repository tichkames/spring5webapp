package hod.springframework.spring5webapp.services.recipe;

import hod.springframework.spring5webapp.commands.recipe.UnitOfMeasureCommand;
import reactor.core.publisher.Flux;

public interface UnitOfMeasureService {

    Flux<UnitOfMeasureCommand> listAllUoms();
}
