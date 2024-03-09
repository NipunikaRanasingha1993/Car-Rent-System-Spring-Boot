package lk.acpt.riyapola.service;

import lk.acpt.riyapola.dto.CarDto;
import lk.acpt.riyapola.entity.Car;
import lk.acpt.riyapola.repo.CarRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepo carRepo;

    public CarService(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public Car saveCar(CarDto carDto){
        return carRepo.save(new Car(carDto.getCarNumber(), carDto.getBrand(), carDto.getModel(), carDto.getTransMode(), carDto.getFuelType()));

    }
    public List<Car> getAllCars(){
        return carRepo.findAll();
    }
    public String deleteCar(Integer id){
        if (carRepo.existsById(id)) {
            carRepo.deleteById(id);
            return "car was deleted.....";
        }
        return "no found car.....";
    }
    public Car updateCar(Integer id,CarDto carDto){
        if(carRepo.existsById(id)){
            return carRepo.save(new Car(id,carDto.getCarNumber(), carDto.getBrand(), carDto.getModel(), carDto.getTransMode(), carDto.getFuelType()));

        }
        return null;
    }
    public Car searchCarById(Integer id){
        Optional<Car> byId = carRepo.findById(id);
        return byId.orElse(null);
    }
}
