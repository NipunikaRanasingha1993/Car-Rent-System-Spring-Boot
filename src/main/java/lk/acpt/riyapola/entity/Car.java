package lk.acpt.riyapola.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
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
}
