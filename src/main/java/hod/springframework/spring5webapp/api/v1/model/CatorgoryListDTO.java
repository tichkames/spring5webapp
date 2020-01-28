package hod.springframework.spring5webapp.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CatorgoryListDTO {

    List<CategoryDTO> categories;

}
