package lk.acpt.riyapola.repo;

import lk.acpt.riyapola.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository<Car,Integer> {
}
