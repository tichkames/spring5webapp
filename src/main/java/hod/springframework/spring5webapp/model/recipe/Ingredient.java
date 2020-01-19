package hod.springframework.spring5webapp.model.recipe;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(exclude = {"uom"})
public class Ingredient {

    @Id
    private String id;
    private String description;
    private BigDecimal amount;

    @DBRef
    private UnitOfMeasure uom;

    public Ingredient(){}

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
    }
}
