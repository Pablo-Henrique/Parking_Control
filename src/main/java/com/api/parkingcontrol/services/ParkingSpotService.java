package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.ParkingSpotEntity;
import com.api.parkingcontrol.repositories.CarRepository;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class ParkingSpotService {

    private final ParkingSpotRepository parkingSpotRepository;
    private final CarRepository carRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository, CarRepository carRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
        this.carRepository = carRepository;
    }

    @Transactional
    public ParkingSpotEntity save(ParkingSpotEntity parkingSpotEntity) {
        return parkingSpotRepository.save(parkingSpotEntity);
    }

    public boolean existsByLicensePlateCar(String licensePlateCar) {
        return carRepository.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean existsByParkingSpotNumber(String parkingSpotNumber) {
        return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByApartmentAndBlock(String apartment, String block) {
        return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
    }

    public Page<ParkingSpotEntity> findAll(Pageable pageable) {
        return parkingSpotRepository.findAll(pageable);
    }

    public Optional<ParkingSpotEntity> findById(UUID id) {
        return parkingSpotRepository.findById(id);
    }

    @Transactional
    public void delete(ParkingSpotEntity parkingSpotEntity) {
        parkingSpotRepository.delete(parkingSpotEntity);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (ParkingSpotService) obj;
        return Objects.equals(this.parkingSpotRepository, that.parkingSpotRepository) &&
                Objects.equals(this.carRepository, that.carRepository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkingSpotRepository, carRepository);
    }

    @Override
    public String toString() {
        return "ParkingSpotService[" +
                "parkingSpotRepository=" + parkingSpotRepository + ", " +
                "carRepository=" + carRepository + ']';
    }

}
