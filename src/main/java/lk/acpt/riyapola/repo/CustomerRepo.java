package lk.acpt.riyapola.repo;

import lk.acpt.riyapola.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
