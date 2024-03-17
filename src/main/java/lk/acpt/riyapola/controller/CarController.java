package lk.acpt.riyapola.controller;

import lk.acpt.riyapola.dto.CarDetailsGetDto;
import lk.acpt.riyapola.dto.CarDto;
import lk.acpt.riyapola.entity.Car;
import lk.acpt.riyapola.service.CarService;
import lk.acpt.riyapola.util.JWTTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/car")
@CrossOrigin
public class CarController {
    private final CarService carService;
    private final JWTTokenGenerator jwtTokenGenerator;

    @Autowired
    public CarController(CarService carService, JWTTokenGenerator jwtTokenGenerator) {
        this.carService = carService;
        this.jwtTokenGenerator = jwtTokenGenerator;
    }

    @PostMapping("/addNewCar")
    public ResponseEntity<Object> saveCar(@RequestHeader(name = "Authorization") String authorizationHeader,@ModelAttribute CarDto carDto) throws IOException, URISyntaxException {
        if (this.jwtTokenGenerator.validateJwtToken(authorizationHeader)) {
            CarDetailsGetDto dto = carService.saveCar(carDto);
            return new ResponseEntity<>(dto, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("invalied token",HttpStatus.FORBIDDEN);
        }

    }
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars(){
        List<Car> allCars = carService.getAllCars();
        return new ResponseEntity<>(allCars,HttpStatus.OK);
    }


}
