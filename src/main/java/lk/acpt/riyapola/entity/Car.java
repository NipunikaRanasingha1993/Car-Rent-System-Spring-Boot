package lk.acpt.riyapola.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String carNumber;
    private String brand;
    private String model;
    private String transMode;
    private String fuelType;

    public Car(Integer id, String carNumber, String brand, String model, String transMode, String fuelType) {
        this.id = id;
        this.carNumber = carNumber;
        this.brand = brand;
        this.model = model;
        this.transMode = transMode;
        this.fuelType = fuelType;
    }

    public Car() {
    }

    public Car(String carNumber, String brand, String model, String transMode, String fuelType) {
        this.carNumber = carNumber;
        this.brand = brand;
        this.model = model;
        this.transMode = transMode;
        this.fuelType = fuelType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTransMode() {
        return transMode;
    }

    public void setTransMode(String transMode) {
        this.transMode = transMode;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
