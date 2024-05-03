package com.project.pdh.repostitory;

import com.project.pdh.entity.ParkginSpotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingSpotRepository extends JpaRepository<ParkginSpotEntity, Long> {
}
