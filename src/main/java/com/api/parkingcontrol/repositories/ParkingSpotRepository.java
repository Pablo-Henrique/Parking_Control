package com.api.parkingcontrol.repositories;

import com.api.parkingcontrol.models.ParkingSpotEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotEntity, UUID> {

    boolean existsByParkingSpotNumber(String parkingSpotNumber);
    boolean existsByApartmentAndBlock(String apartment, String block);

    @Override
    @Query(value = "SELECT p FROM ParkingSpotEntity p join fetch CarEntity")
    Page<ParkingSpotEntity> findAll(Pageable pageable);
}
