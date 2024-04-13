package lk.acpt.riyapola.dto;

import lk.acpt.riyapola.entity.Images;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarDto {
    private Integer carId;
    private String model;
    private String brand;
    private String transMode;
    private String fuelType;
    private String engineCap;
    private List<Images> images;


}
