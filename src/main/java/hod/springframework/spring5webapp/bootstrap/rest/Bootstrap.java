package hod.springframework.spring5webapp.bootstrap.rest;

import hod.springframework.spring5webapp.model.rest.CategoryRest;
import hod.springframework.spring5webapp.model.rest.Customer;
import hod.springframework.spring5webapp.repositories.rest.CategoryRepositoryRest;
import hod.springframework.spring5webapp.repositories.rest.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepositoryRest categoryRespositoryRest;
    private final CustomerRepository customerRepository;

    public Bootstrap(CategoryRepositoryRest categoryRespositoryRest, CustomerRepository customerRepository) {
        this.categoryRespositoryRest = categoryRespositoryRest;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        loadCategories();
        loadCustomers();
    }

    private void loadCategories() {
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

        categoryRespositoryRest.save(fruits);
        categoryRespositoryRest.save(dried);
        categoryRespositoryRest.save(fresh);
        categoryRespositoryRest.save(exotic);
        categoryRespositoryRest.save(nuts);

        System.out.println("Categories Loaded: " + categoryRespositoryRest.count());
    }

    private void loadCustomers() {
        //given
        Customer customer1 = new Customer();
        customer1.setId(1l);
        customer1.setFirstname("Michale");
        customer1.setLastname("Weston");
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setId(2l);
        customer2.setFirstname("Sam");
        customer2.setLastname("Axe");

        customerRepository.save(customer2);

        System.out.println("Customers Loaded: " + customerRepository.count());
    }
}
