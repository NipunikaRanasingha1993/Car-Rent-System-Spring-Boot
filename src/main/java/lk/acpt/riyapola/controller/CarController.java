package lk.acpt.riyapola.controller;

import lk.acpt.riyapola.dto.CarDto;
import lk.acpt.riyapola.entity.Car;
import lk.acpt.riyapola.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
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


}
