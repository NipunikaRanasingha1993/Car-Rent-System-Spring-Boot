package lk.acpt.riyapola.service;

import lk.acpt.riyapola.dto.CarDetailsGetDto;
import lk.acpt.riyapola.dto.CarDto;
import lk.acpt.riyapola.entity.Car;
import lk.acpt.riyapola.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class CarService {
    private final CarRepo carRepo;

    @Autowired
    public CarService(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public CarDetailsGetDto saveCar(CarDto carDto) throws IOException, URISyntaxException {
        String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
        File uploadDir = new File(projectPath + "/uploads");
//      meke hari nam project path eka denna one /src/main/resources/static menna me path erke
        uploadDir.mkdir();


        carDto.getCarName().transferTo(new File(uploadDir.getAbsolutePath() + "/" + carDto.getCarName().getOriginalFilename()));

        Car car = new Car(carDto.getModel(), carDto.getBrand(), carDto.getTransMode(), carDto.getFuelType(), carDto.getEngineCap(), carDto.getCarName().getOriginalFilename());
        car.setCarName("uploads/" +carDto.getCarName().getOriginalFilename());


        Car save = carRepo.save(car);
        System.out.println(save);

//        return (save);
        return new CarDetailsGetDto(save.getId(),save.getModel(), save.getBrand(), save.getTransMode(),save.getFuelType(), save.getEngineCap(),save.getCarName());

    }

    public List<Car> getAllCars(){
        return carRepo.findAll();
    }


}
