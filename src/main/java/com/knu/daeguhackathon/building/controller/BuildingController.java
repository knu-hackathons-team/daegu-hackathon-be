package com.knu.daeguhackathon.building.controller;

import com.knu.daeguhackathon.building.controller.dto.BuildingRequest;
import com.knu.daeguhackathon.building.controller.dto.BuildingResponse;
import com.knu.daeguhackathon.building.service.BuildingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/building")
public class BuildingController {
<<<<<<<HEAD

=======
    private final BuildingService buildingService;

    @GetMapping("")
    public BuildingResponse.Info getBuildingInfo(
        @RequestBody BuildingRequest.Name request
    ) {
        return buildingService.getBuildingInfoByName(request);
    }

    @GetMapping("/all")
    public BuildingResponse.Buildings getAllBuildings() {
        return buildingService.getAllBuildings();
    }
>>>>>>>main
}
