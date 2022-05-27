package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.models.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarEntity, Long> {

    boolean existsByLicensePlateCar(String licensePlateCar);
}
