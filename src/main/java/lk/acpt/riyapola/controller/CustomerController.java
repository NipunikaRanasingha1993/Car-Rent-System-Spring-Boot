package lk.acpt.riyapola.controller;

import lk.acpt.riyapola.dto.CustomerDto;
import lk.acpt.riyapola.entity.Customer;
import lk.acpt.riyapola.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody CustomerDto customer){
        Customer cus = customerService.saveCustomer(customer);
        return new ResponseEntity<>(cus, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity <List<Customer>> getAllCustomer(){
        List<Customer> allCustomer = customerService.getAllCustomer();
        return new ResponseEntity<>(allCustomer,HttpStatus.OK);
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer customerId,@RequestBody CustomerDto customerDto ){
        Customer customer = customerService.updateCustomer(customerId, customerDto);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer customerId){
        String output = customerService.deleteCustomer(customerId);
        return new ResponseEntity<>(output,HttpStatus.CREATED);
    }

    @GetMapping("/search_customer_by_id/{customerId}")
    public ResponseEntity<Customer> searchCustomerById(@PathVariable Integer customerId){
        Customer customer = customerService.searchCustomerById(customerId);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

}
