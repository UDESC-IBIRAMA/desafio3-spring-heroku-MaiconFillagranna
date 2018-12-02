package com.crud.vehicles.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "vehicle")
public class VehicleEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    private String name;

    @Enumerated(EnumType.STRING)
    private VehicleType type;

    @OneToOne
    private AutomakerEntity automaker;

    @OneToOne
    private ModelEntity model;

    private String color;

    private Integer kilometer;

    private Double motor;

    private Double value;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public AutomakerEntity getAutomaker() {
        return automaker;
    }

    public void setAutomaker(AutomakerEntity automaker) {
        this.automaker = automaker;
    }

    public ModelEntity getModel() {
        return model;
    }

    public void setModel(ModelEntity model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getKilometer() {
        return kilometer;
    }

    public void setKilometer(Integer kilometer) {
        this.kilometer = kilometer;
    }

    public Double getMotor() {
        return motor;
    }

    public void setMotor(Double motor) {
        this.motor = motor;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
