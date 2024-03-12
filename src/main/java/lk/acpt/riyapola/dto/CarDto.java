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
    private int id;
    private String model;
    private String brand;
    private String transMode;
    private String fuelType;
    private String engineCap;
    private MultipartFile carName;
}
