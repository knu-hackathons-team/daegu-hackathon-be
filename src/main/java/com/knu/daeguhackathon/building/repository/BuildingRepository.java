package com.knu.daeguhackathon.building.repository;

import com.knu.daeguhackathon.building.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
}