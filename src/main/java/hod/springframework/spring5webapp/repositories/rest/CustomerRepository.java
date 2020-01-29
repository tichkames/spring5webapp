package hod.springframework.spring5webapp.repositories.rest;

import hod.springframework.spring5webapp.model.rest.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
