package com.api.parkingcontrol.repository;


import com.api.parkingcontrol.models.CarEntity;
import com.api.parkingcontrol.models.ParkingSpotEntity;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("all")
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(profiles = "test")
public class ParkingSpotRepositoryTest {

    @Autowired
    private ParkingSpotRepository repository;

//    @Test
//    public void testSaveParkingSpot() {
//        ParkingSpotEntity parkingSpot = new ParkingSpotEntity();
//        parkingSpot.setParkingSpotNumber("A301");
//        parkingSpot.setRegistrationDate(LocalDateTime.now());
//        parkingSpot.setResponsibleName("Lucas Green");
//        parkingSpot.setApartment("101");
//        parkingSpot.setBlock("A");
//
//        CarEntity car = new CarEntity();
//        car.setLicensePlateCar("ASE7231");
//        car.setBrandCar("Chevrolet");
//        car.setModelCar("Camaro");
//        car.setColorCar("Black");
//
//        parkingSpot.setCarEntity(car);
//        ParkingSpotEntity response = repository.save(parkingSpot);
//
//        assertNotNull(response);
//    }


}
