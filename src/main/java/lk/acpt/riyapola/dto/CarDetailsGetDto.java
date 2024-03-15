package lk.acpt.riyapola.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarDetailsGetDto {
    private Long id;
    private String model;
    private String brand;
    private String transMode;
    private String fuelType;
    private String engineCap;
    private String carName;

}
