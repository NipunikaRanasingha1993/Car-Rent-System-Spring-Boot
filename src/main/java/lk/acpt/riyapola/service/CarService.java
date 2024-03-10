package lk.acpt.riyapola.service;

import lk.acpt.riyapola.dto.CarDto;
import lk.acpt.riyapola.entity.Car;
import lk.acpt.riyapola.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepo carRepo;

    @Autowired
    public CarService(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public Car saveCar(CarDto carDto){
        return carRepo.save(new Car(carDto.getModel(),carDto.getBrand(), carDto.getTransMode(), carDto.getFuelType(), carDto.getEngineCap()));
    }

    public List<Car> getAllCars(){
        return carRepo.findAll();
    }


}
