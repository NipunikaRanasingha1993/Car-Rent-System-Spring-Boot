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
    private Integer imageId;
    private String imageName;

    @ManyToOne
    @JoinColumn(name="carId")
    Car car;

    public Images(Integer imageId, String imageName) {
        this.imageId = imageId;
        this.imageName = imageName;
    }
}
