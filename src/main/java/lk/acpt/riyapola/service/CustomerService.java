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
    public CustomerService(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }

    public Customer saveCustomer(CustomerDto customerDto) {
        return customerRepo.save(new Customer(customerDto.getName(), customerDto.getCity(), customerDto.getContact(), customerDto.getEmail()));
    }

    public List<Customer> getAllCustomer(){
        return customerRepo.findAll();
    }

    public Customer updateCustomer(Integer id, CustomerDto customerDto){
        if(customerRepo.existsById(id)){
            return customerRepo.save(new Customer(id,customerDto.getName(), customerDto.getCity(), customerDto.getContact(), customerDto.getEmail()));
        }
        return null;
    }
    public String deleteCustomer(Integer id){
        if(customerRepo.existsById(id)){
            customerRepo.deleteById(id);
            return "customer deleted.....";
        }
        return "no found customer";
    }
    public Customer searchCustomerById(Integer id){
        Optional<Customer> byId =customerRepo.findById(id);
        return byId.orElse(null);
    }
}
