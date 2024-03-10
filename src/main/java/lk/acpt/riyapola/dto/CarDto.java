package lk.acpt.riyapola.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private int id;
    private String model;
    private String brand;
    private String transMode;
    private String fuelType;
    private String engineCap;
}
