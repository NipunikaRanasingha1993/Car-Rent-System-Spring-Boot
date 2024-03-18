package lk.acpt.riyapola.service;

import lk.acpt.riyapola.dto.CustomerDto;
import lk.acpt.riyapola.entity.Customer;
import lk.acpt.riyapola.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Customer> getAllCustomer(){
        return customerRepo.findAll();
    }

    public Customer updateCustomer(Long id, CustomerDto customerDto){
        if(customerRepo.existsById(id)){
            return customerRepo.save(new Customer(id,customerDto.getName(),customerDto.getContact(),customerDto.getEmail(),customerDto.getPassword()));
        }
        return null;

    }

    public String deleteCustomer(Long id) {
        if (customerRepo.existsById(id)) {
            customerRepo.deleteById(id);
            return "customer deleted....!";
        } else {
            return "no found customer....!";
        }
    }

    public Customer searchCustomer(Long id){
        Optional<Customer> byId = customerRepo.findById(id);
        return byId.orElse(null);
    }

}
