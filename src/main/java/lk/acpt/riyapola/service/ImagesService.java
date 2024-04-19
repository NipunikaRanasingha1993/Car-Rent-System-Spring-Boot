package lk.acpt.riyapola.service;

import lk.acpt.riyapola.dto.CarDto;
import lk.acpt.riyapola.dto.ImagesDetailsGetDto;
import lk.acpt.riyapola.dto.ImagesDto;
import lk.acpt.riyapola.entity.Car;
import lk.acpt.riyapola.entity.Images;
import lk.acpt.riyapola.repo.ImagesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

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


        Images img = new Images(imagesDto.getImageName().getOriginalFilename(),imagesDto.getCarId());

        img.setImageName("uploads/" +imagesDto.getImageName().getOriginalFilename());
        img.setCarId(imagesDto.getCarId());


        Images save = imagesRepo.save(img);
        System.out.println(save);
        return new ImagesDetailsGetDto(save.getImagesId(), save.getImageName(),save.getCarId());
    }



//    public List<Images> getAllImages(){
//        return imagesRepo.findAll();
//    }

    public ImagesDetailsGetDto updateImages(Integer imagesId, ImagesDto imagesDto) throws URISyntaxException, IOException {
        String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
        File uploadDir = new File(projectPath + "/src/main/resources/static/uploads");


        uploadDir.mkdir();

        imagesDto.getImageName().transferTo(new File(uploadDir.getAbsolutePath() + "/" + imagesDto.getImageName().getOriginalFilename()));


        Images img = new Images(imagesDto.getImageName().getOriginalFilename(),imagesDto.getCarId());

        img.setImageName("uploads/" +imagesDto.getImageName().getOriginalFilename());
        img.setCarId(imagesDto.getCarId());
        img.setImagesId(imagesId);

        if(imagesRepo.existsById(imagesId)){
            Images save = imagesRepo.save(img);
            return new ImagesDetailsGetDto(save.getImagesId(), save.getImageName(),save.getCarId());
        }
        return null;
    }
}
