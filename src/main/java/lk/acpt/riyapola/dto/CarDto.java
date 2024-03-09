package lk.acpt.riyapola.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private int id;
    private String carNumber;
    private String brand;
    private String model;
    private String transMode;
    private String fuelType;
}
