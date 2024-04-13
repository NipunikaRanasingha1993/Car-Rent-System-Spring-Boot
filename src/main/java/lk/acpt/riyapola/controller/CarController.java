package lk.acpt.riyapola.controller;

import lk.acpt.riyapola.dto.CarDto;
import lk.acpt.riyapola.entity.Car;
import lk.acpt.riyapola.service.CarService;
import lk.acpt.riyapola.util.JWTTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Object> saveCar(@RequestHeader(name= "Authorization") String authorizationHeader,@RequestBody CarDto carDto){
        if(this.jwtTokenGenerator.validateJwtToken(authorizationHeader)){
            Car car = carService.saveCar(carDto);
            return new ResponseEntity<>(car,HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("invalied token" , HttpStatus.FORBIDDEN);
        }
    }

//    @PostMapping("/addNewCar")
//    public ResponseEntity<Object> saveCar(@RequestHeader(name = "Authorization") String authorizationHeader,@ModelAttribute CarDto carDto) throws IOException, URISyntaxException {
//        if (this.jwtTokenGenerator.validateJwtToken(authorizationHeader)) {
//            CarDetailsGetDto dto = carService.saveCar(carDto);
//            return new ResponseEntity<>(dto, HttpStatus.CREATED);
//        } else {
//            return new ResponseEntity<>("invalied token",HttpStatus.FORBIDDEN);
//        }
//
//    }
    @GetMapping("/getAllCar")
    public ResponseEntity<Object> getAllCars(){
        List<Car> allCars = carService.getAllCars();
        return new ResponseEntity<>(allCars,HttpStatus.OK);
    }

    @PutMapping("/{carId}")
    public ResponseEntity<Object> updateCar(@RequestHeader(name="Authorization") String authorizationHeader ,@PathVariable Integer carId,@RequestBody CarDto carDto) {
        if (this.jwtTokenGenerator.validateJwtToken(authorizationHeader)) {
            Car car = carService.updateCar(carId, carDto);
            return new ResponseEntity<>(car, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("invalied token" , HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/{carId}")
    public ResponseEntity<String> deleteCar(@RequestHeader(name="Authorization") String authorizationHeader, @PathVariable Integer carId){
        if(this.jwtTokenGenerator.validateJwtToken(authorizationHeader)){
            String delCar = carService.deleteCar(carId);
            return new ResponseEntity<>(delCar,HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("invalied token" , HttpStatus.FORBIDDEN);
        }

    }

    @GetMapping("/search_car_by_id/{carId}")
    public ResponseEntity<Object> searchCar(@RequestHeader(name="Authorization") String authorizationHeader, @PathVariable Integer carId){
        if(this.jwtTokenGenerator.validateJwtToken(authorizationHeader)){
            Car car = carService.searchCar(carId);
            return new ResponseEntity<>(car,HttpStatus.OK);
        } else {
            return new ResponseEntity<>("invalied token" , HttpStatus.FORBIDDEN);
        }

    }



}
