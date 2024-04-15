package lk.acpt.riyapola.controller;

import lk.acpt.riyapola.dto.CarDto;
import lk.acpt.riyapola.dto.ImagesDetailsGetDto;
import lk.acpt.riyapola.dto.ImagesDto;
import lk.acpt.riyapola.entity.Car;
import lk.acpt.riyapola.entity.Images;
import lk.acpt.riyapola.service.ImagesService;
import lk.acpt.riyapola.util.JWTTokenGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/images")
@CrossOrigin
public class ImagesController {
    private final ImagesService imagesService;
    private final JWTTokenGenerator jwtTokenGenerator;

    @Autowired
    public ImagesController(ImagesService imagesService, JWTTokenGenerator jwtTokenGenerator) {
        this.imagesService = imagesService;
        this.jwtTokenGenerator = jwtTokenGenerator;
    }

    @PostMapping("/addNewImages")
    public ResponseEntity<Object> saveImages(@RequestHeader(name= "Authorization") String authorizationHeader, @ModelAttribute ImagesDto imagesDto) throws IOException, URISyntaxException {
        if (this.jwtTokenGenerator.validateJwtToken(authorizationHeader)) {
            System.out.println("gtfrgtfgtgfgfgfgfg"+ imagesDto.getCarId());

            ImagesDetailsGetDto iii = imagesService.saveImages(imagesDto);
            return new ResponseEntity<>(iii, HttpStatus.CREATED);
        }

        else {
            return new ResponseEntity<>("invalid Token", HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/getAllImages")
    public ResponseEntity<Object> getAllImages(){
        List<Images> allImages = imagesService.getAllImages();
        return new ResponseEntity<>(allImages,HttpStatus.OK);
    }



}
