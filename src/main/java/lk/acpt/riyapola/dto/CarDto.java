package lk.acpt.riyapola.dto;

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
    private List<ImagesDetailsGetDto> images;

    public CarDto(String model, String brand, String transMode, String fuelType, String engineCap) {
        this.model = model;
        this.brand = brand;
        this.transMode = transMode;
        this.fuelType = fuelType;
        this.engineCap = engineCap;
    }
}
