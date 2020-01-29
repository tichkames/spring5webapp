package hod.springframework.spring5webapp.api.v1.mapper;

import hod.springframework.spring5webapp.api.v1.model.CustomerDTO;
import hod.springframework.spring5webapp.model.rest.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCustomerDTO(Customer customer);

    Customer customerDtoToCustomer(CustomerDTO customerDTO);
}
