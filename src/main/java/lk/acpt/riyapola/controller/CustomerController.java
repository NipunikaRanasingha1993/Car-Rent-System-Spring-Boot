package lk.acpt.riyapola.controller;

import lk.acpt.riyapola.dto.CustomerDto;
import lk.acpt.riyapola.entity.Customer;
import lk.acpt.riyapola.repo.CustomerRepo;
import lk.acpt.riyapola.service.CustomerService;
import lk.acpt.riyapola.util.JWTTokenGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerRepo customerRepo;

    private final CustomerService customerService;
    private final JWTTokenGenerator jwtTokenGenerator;

    public CustomerController(CustomerRepo customerRepo, CustomerService customerService, JWTTokenGenerator jwtTokenGenerator) {
        this.customerRepo = customerRepo;
        this.customerService = customerService;
        this.jwtTokenGenerator = jwtTokenGenerator;
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> customerSave(@RequestBody CustomerDto customerDto){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String newPassword = bCryptPasswordEncoder.encode(customerDto.getPassword());
        customerDto.setPassword(newPassword);
        Customer customer = customerService.customerSave(customerDto);
            return new ResponseEntity<>(customer, HttpStatus.CREATED);
        }



    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> customerLogin(@RequestBody CustomerDto customerDto){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        Map<String,String> response = new HashMap<>();

        String Pw = customerRepo.findCustomerByEmailToGetPw(customerDto.getEmail());
        Customer customerByEmail = customerRepo.findCustomerByEmail(customerDto.getEmail());

        if(customerByEmail!=null && bCryptPasswordEncoder.matches(customerDto.getPassword(),Pw)){
            String token = this.jwtTokenGenerator.generateJwtToken2(customerByEmail);
            response.put("token",token);
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        else {
            response.put("message", "wrong Credentials");
            return new ResponseEntity<>(response,HttpStatus.FORBIDDEN);
        }

    }

    @GetMapping("/getAllCustomer")
    public ResponseEntity<Object> getAllCustomer(@RequestHeader(name = "Authorization") String authorizationHeader){
        if(this.jwtTokenGenerator.validateJwtToken(authorizationHeader)){
            List<Customer> allCustomer = customerService.getAllCustomer();
            return new ResponseEntity<>(allCustomer,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("invalied token",HttpStatus.FORBIDDEN);
        }

    }

    @PutMapping("/{customerId}")
    public ResponseEntity<Object> updateCustomer(@RequestHeader(name = "Authorization") String authorizationHeader,@PathVariable Long customerId ,@RequestBody CustomerDto customerDto){
        if(this.jwtTokenGenerator.validateJwtToken(authorizationHeader)){
            Customer customer = customerService.updateCustomer(customerId, customerDto);
            return new ResponseEntity<>(customer,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("invalied token" , HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Object> deleteCustomer(@RequestHeader(name = "Authorization") String authorizationHeader,@PathVariable Long customerId){
        if(this.jwtTokenGenerator.validateJwtToken(authorizationHeader)){
            String delCustomer = customerService.deleteCustomer(customerId);
            return new ResponseEntity<>(delCustomer,HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("invalied token" , HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/search_customer_by_id/{customerId}")
    public ResponseEntity<Object> searchCustomer(@RequestHeader(name = "Authorization") String authorizationHeader,@PathVariable Long customerId){
        if(this.jwtTokenGenerator.validateJwtToken(authorizationHeader)){
            Customer customer = customerService.searchCustomer(customerId);
            return new ResponseEntity<>(customer,HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>("invalied token" , HttpStatus.FORBIDDEN);
        }
    }
}
