package com.api.parkingcontrol.services;

import com.api.parkingcontrol.models.ParkingSpotEntity;
import com.api.parkingcontrol.repositories.CarRepository;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
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

    public List<ParkingSpotEntity> findAll() {
        return parkingSpotRepository.findAll();
    }

    public Optional<ParkingSpotEntity> findById(UUID id) {
        return parkingSpotRepository.findById(id);
    }

    @Transactional
    public void delete(ParkingSpotEntity parkingSpotEntity) {
        parkingSpotRepository.delete(parkingSpotEntity);
    }
}
