package com.knu.daeguhackathon.distance;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Distance {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotNull
    private String startBuildingName;
    @NotNull
    private String endBuildingName;
    @NotNull
    private int buildingDistance;
    @NotNull
    private int estimatedTime;
    @NotNull
    private String imageUrl;
}
