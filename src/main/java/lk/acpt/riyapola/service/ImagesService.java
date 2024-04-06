package lk.acpt.riyapola.service;

import lk.acpt.riyapola.dto.ImagesDetailsGetDto;
import lk.acpt.riyapola.dto.ImagesDto;
import lk.acpt.riyapola.entity.Car;
import lk.acpt.riyapola.entity.Images;
import lk.acpt.riyapola.repo.ImagesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

@Service
public class ImagesService {

    private final ImagesRepo imagesRepo;

    public ImagesService(ImagesRepo imagesRepo) {
        this.imagesRepo = imagesRepo;
    }

    public ImagesDetailsGetDto saveImages(ImagesDto imagesDto) throws IOException, URISyntaxException {
        String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
        File uploadDir = new File(projectPath + "/src/main/resources/static/uploads");
        uploadDir.mkdir();

        imagesDto.getImageName().transferTo(new File(uploadDir.getAbsolutePath() + "/" + imagesDto.getImageName().getOriginalFilename()));

        Images img = new Images(imagesDto.getCarId(),imagesDto.getImageName().getOriginalFilename());
        System.out.println(img);
        img.setImageName("uploads/" +imagesDto.getImageName().getOriginalFilename());


        Images newImage = imagesRepo.save(img);

        System.out.println(newImage);

        return new ImagesDetailsGetDto(newImage.getImageId(), newImage.getImageName(),new Car(imagesDto.getCarId()));
    }
}
