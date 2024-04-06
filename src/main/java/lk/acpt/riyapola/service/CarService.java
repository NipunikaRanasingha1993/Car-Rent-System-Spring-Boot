package lk.acpt.riyapola.service;

import lk.acpt.riyapola.dto.CarDto;
import lk.acpt.riyapola.entity.Car;
import lk.acpt.riyapola.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    private final CarRepo carRepo;

    @Autowired
    public CarService(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public Car saveCar(CarDto carDto){
        return carRepo.save(new Car(carDto.getBrand(), carDto.getModel(), carDto.getTransMode(), carDto.getFuelType(), carDto.getEngineCap()));
    }

//    public CarDetailsGetDto saveCar(CarDto carDto) throws IOException, URISyntaxException {
//        String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
//        File uploadDir = new File(projectPath + "/src/main/resources/static/uploads");
////      meke hari nam project path eka denna one /src/main/resources/static menna me path erke
//        uploadDir.mkdir();
//
//
//        carDto.getCarName().transferTo(new File(uploadDir.getAbsolutePath() + "/" + carDto.getCarName().getOriginalFilename()));
//
//        Car car = new Car(carDto.getModel(), carDto.getBrand(), carDto.getTransMode(), carDto.getFuelType(), carDto.getEngineCap(), carDto.getCarName().getOriginalFilename());
//        car.setCarName("uploads/" +carDto.getCarName().getOriginalFilename());
//
//
//        Car carNew = carRepo.save(car);
//        System.out.println(carNew);
//
////     return (save);
//        return new CarDetailsGetDto(carNew.getId(), carNew.getModel(), carNew.getBrand(), carNew.getTransMode(), carNew.getFuelType(), carNew.getEngineCap(), carNew.getCarName());
//    }

    public List<Car> getAllCars(){
        return carRepo.findAll();
    }

//    public CarDetailsGetDto updateCar(Long id, CarDto carDto){
//        if(carRepo.existsById(id)){
//            Car newCar = carRepo.save(new Car(id, carDto.getModel(), carDto.getBrand(), carDto.getTransMode(), carDto.getFuelType(), carDto.getEngineCap(), carDto.getCarName().getOriginalFilename()));
//            return new CarDetailsGetDto(newCar.getId(), newCar.getModel(), newCar.getBrand(), newCar.getTransMode(), newCar.getFuelType(), newCar.getEngineCap(), newCar.getCarName());
//        }
//        return null;
//    }

    public String deleteCar(Long id){
        if(carRepo.existsById(id)){
            carRepo.deleteById(id);
            return "car deleted......";
        }else{
            return "no found car.....";
        }
    }

    public Car searchCar(Long id){
        Optional<Car> byId = carRepo.findById(id);
        return byId.orElse(null);

    }
}
