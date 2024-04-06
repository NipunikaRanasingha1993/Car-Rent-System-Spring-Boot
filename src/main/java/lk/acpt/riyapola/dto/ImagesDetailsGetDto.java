package lk.acpt.riyapola.dto;

import lk.acpt.riyapola.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ImagesDetailsGetDto {
    private Integer imageId;
    private String imageName;
    private Integer carId;


    public ImagesDetailsGetDto(Integer imageId) {
    }

    public ImagesDetailsGetDto(Integer imageId, String imageName, Car car) {
    }
}
