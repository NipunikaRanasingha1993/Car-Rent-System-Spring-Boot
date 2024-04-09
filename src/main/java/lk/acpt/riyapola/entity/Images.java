package lk.acpt.riyapola.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imagesId;
    private String imageName;

    @ManyToOne
    @JoinColumn(name="car_id")
    Car car;

    public Images(String originalFilename, Car car) {
        this.imageName=originalFilename;
        this.car=car;
    }
}
