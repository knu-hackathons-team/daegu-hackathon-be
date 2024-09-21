package com.knu.daeguhackathon.building.repository;

import com.knu.daeguhackathon.building.Building;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BuildingRepository extends JpaRepository<Building, Long> {
<<<<<<<HEAD
=======

    Optional<Building> findByBuildingName(String buildingName);

    List<Building> findAllByBuildingName(String buildingName);

>>>>>>>main

}
