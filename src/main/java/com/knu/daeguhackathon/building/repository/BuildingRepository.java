package com.knu.daeguhackathon.building.repository;

import com.knu.daeguhackathon.building.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
    Optional<Building> findByBuildingName(String buildingName);

    List<Building> findAllByBuildingName(String buildingName);


}
