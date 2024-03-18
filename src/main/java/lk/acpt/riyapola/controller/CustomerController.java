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
        }
        else {
            response.put("message", "wrong Credentials");
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
