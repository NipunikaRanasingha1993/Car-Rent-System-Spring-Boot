package lk.acpt.riyapola.repo;

import lk.acpt.riyapola.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

    @Query(nativeQuery = true,value = "SELECT password FROM customer WHERE email=:email")
    String findCustomerByEmailToGetPw(String email);

    Customer findCustomerByEmail(String email);
}
