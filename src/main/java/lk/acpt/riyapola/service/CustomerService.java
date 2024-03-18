package lk.acpt.riyapola.service;

import lk.acpt.riyapola.dto.CustomerDto;
import lk.acpt.riyapola.entity.Customer;
import lk.acpt.riyapola.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer customerSave(CustomerDto customerDto){
        return customerRepo.save(new Customer(customerDto.getName(), customerDto.getContact(), customerDto.getEmail(), customerDto.getPassword()));
    }
}
