package hod.springframework.spring5webapp.bootstrap.rest;

import hod.springframework.spring5webapp.model.rest.CategoryRest;
import hod.springframework.spring5webapp.repositories.rest.CategoryRepositoryRest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private CategoryRepositoryRest categoryRepositoryRest;

    public Bootstrap(CategoryRepositoryRest categoryRepositoryRest) {
        this.categoryRepositoryRest = categoryRepositoryRest;
    }

    @Override
    public void run(String... args) throws Exception {
        CategoryRest fruits = new CategoryRest();
        fruits.setName("Fruits");

        CategoryRest dried = new CategoryRest();
        dried.setName("Dried");

        CategoryRest fresh = new CategoryRest();
        fresh.setName("Fresh");

        CategoryRest exotic = new CategoryRest();
        exotic.setName("Exotic");

        CategoryRest nuts = new CategoryRest();
        nuts.setName("Nuts");

        categoryRepositoryRest.save(fruits);
        categoryRepositoryRest.save(dried);
        categoryRepositoryRest.save(fresh);
        categoryRepositoryRest.save(exotic);
        categoryRepositoryRest.save(nuts);

        System.out.println("Data Loaded = " + categoryRepositoryRest.count());
    }
}
