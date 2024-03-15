package lk.acpt.riyapola.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarDto {
    private Long id;
    private String model;
    private String brand;
    private String transMode;
    private String fuelType;
    private String engineCap;
    private MultipartFile carName;

    public CarDto(String model, String brand, String transMode, String fuelType, String engineCap, MultipartFile carName) {
        this.model = model;
        this.brand = brand;
        this.transMode = transMode;
        this.fuelType = fuelType;
        this.engineCap = engineCap;
        this.carName = carName;
    }
}
