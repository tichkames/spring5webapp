package hod.springframework.spring5webapp.model.recipe;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document
public class UnitOfMeasure {

    @Id
    private String id;
    private String description;
}
