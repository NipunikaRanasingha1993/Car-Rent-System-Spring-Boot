package lk.acpt.riyapola.entity;

import jakarta.persistence.*;
import lk.acpt.riyapola.dto.ImagesDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer carId;
    private String model;
    private String brand;
    private String transMode;
    private String fuelType;
    private String engineCap;

    public Car(String model, String brand, String transMode, String fuelType, String engineCap) {
        this.model = model;
        this.brand = brand;
        this.transMode = transMode;
        this.fuelType = fuelType;
        this.engineCap = engineCap;
    }


    @OneToMany(
            cascade = CascadeType.ALL
    )

    @JoinColumn(name = "carId")
    List<Images> images = new ArrayList<>();


    public Car(Integer id, String model, String brand, String transMode, String fuelType, String engineCap) {
    }
}
