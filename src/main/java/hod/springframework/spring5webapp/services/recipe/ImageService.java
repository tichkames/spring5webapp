package hod.springframework.spring5webapp.services.recipe;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    void saveImageFile(String recipeId, MultipartFile file);
}
