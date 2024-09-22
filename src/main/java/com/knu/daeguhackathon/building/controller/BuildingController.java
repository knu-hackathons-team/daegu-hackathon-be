package com.knu.daeguhackathon.building.controller;

import com.knu.daeguhackathon.building.controller.dto.BuildingResponse;
import com.knu.daeguhackathon.building.service.BuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/building")
public class BuildingController {

    private final BuildingService buildingService;

    @GetMapping("")
    public BuildingResponse.Info getBuildingInfo(
        @RequestParam("name") String name
    ) {
        return buildingService.getBuildingInfoByName(name);
    }

    @GetMapping("/all")
    public BuildingResponse.Buildings getAllBuildings() {
        return buildingService.getAllBuildings();
    }
}
