package lk.acpt.riyapola.controller;

import lk.acpt.riyapola.dto.CarDto;
import lk.acpt.riyapola.entity.Car;
import lk.acpt.riyapola.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService){
        this.carService = carService;
    }
    @PostMapping
    public ResponseEntity<Car> saveCar(@RequestBody CarDto carDto){
        Car car = carService.saveCar(carDto);
        return new ResponseEntity<>(car, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars(){
        List<Car> allCars = carService.getAllCars();
        return new ResponseEntity<>(allCars,HttpStatus.OK);
    }
    @DeleteMapping("/{carId}")
    public ResponseEntity<String> deleteCar(@PathVariable Integer carId){
        String output = carService.deleteCar(carId);
        return new ResponseEntity<>(output,HttpStatus.CREATED);
    }
    @PutMapping("/{carId}")
    public ResponseEntity<Car> updateCar(@PathVariable Integer carId,@RequestBody CarDto carDto){
        Car car = carService.updateCar(carId, carDto);
        return new ResponseEntity<>(car,HttpStatus.OK);
    }
    @GetMapping("/search_car_by_id/{carId}")
    public ResponseEntity<Car> searchCarById(@PathVariable Integer carId){
        Car car = carService.searchCarById(carId);
        return new ResponseEntity<>(car,HttpStatus.OK);
    }
}
