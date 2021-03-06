package com.api.parkingcontrol.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "TB_CAR_MODEL")
public class CarEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -3069345271854708376L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCarModel;

    @Column(name = "CAR_PLATE", nullable = false, unique = true, length = 7)
    private String licensePlateCar;

    @Column(name = "BRAND_CAR", nullable = false, length = 70)
    private String brandCar;

    @Column(name = "MODEL_CAR", nullable = false, length = 70)
    private String modelCar;

    @Column(name = "COLOR_CAR", nullable = false, length = 70)
    private String colorCar;

    @OneToMany(mappedBy = "carEntity", cascade = CascadeType.PERSIST)
    private List<ParkingSpotEntity> parkingSpot;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarEntity carEntity = (CarEntity) o;
        return Objects.equals(idCarModel, carEntity.idCarModel) && Objects.equals(licensePlateCar, carEntity.licensePlateCar) && Objects.equals(brandCar, carEntity.brandCar) && Objects.equals(modelCar, carEntity.modelCar) && Objects.equals(colorCar, carEntity.colorCar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCarModel, licensePlateCar, brandCar, modelCar, colorCar);
    }
}
