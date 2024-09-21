package com.knu.daeguhackathon.building.service;

import com.knu.daeguhackathon.building.Building;
import com.knu.daeguhackathon.building.controller.dto.BuildingRequest;
import com.knu.daeguhackathon.building.controller.dto.BuildingResponse;
import com.knu.daeguhackathon.building.repository.BuildingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BuildingService {

    private final BuildingRepository buildingRepository;

    public BuildingResponse.Info getBuildingInfoByName(BuildingRequest.Name request){
        Building building = buildingRepository.findByBuildingName(request.name())
                .orElseThrow(() -> new RuntimeException("해당 빌딩을 찾을 수 없습니다. "));
        return BuildingResponse.Info.builder()
                .buildingName(building.getBuildingName())
                .latitude(building.getLatitude())
                .longitude(building.getLongitude())
                .build();

    }
    public BuildingResponse.Buildings getAllBuildings(){
        List<Building> buildingList = buildingRepository.findAll();
        if(buildingList.isEmpty()){
            throw new RuntimeException("건물이 하나도 없습니다.");
        }
        List<BuildingResponse.Info> buildingInfoList = buildingList.stream()
                .map(
                        building -> BuildingResponse.Info.builder()
                                .buildingName(building.getBuildingName())
                                .longitude(building.getLongitude())
                                .latitude(building.getLatitude())
                                .build()
                )
                .toList();

        return BuildingResponse.Buildings.builder()
                .buildings(buildingInfoList)
                .build();
    }

}
