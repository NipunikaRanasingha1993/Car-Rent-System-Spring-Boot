package lk.acpt.riyapola.dto;

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
    private Integer car_id;

}
