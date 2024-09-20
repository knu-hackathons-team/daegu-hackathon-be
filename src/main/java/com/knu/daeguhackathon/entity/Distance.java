package com.knu.daeguhackathon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Distance {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotNull
    private String startBuilingName;
    @NotNull
    private String endBuilingName;
    @NotNull
    private int builingDistance;
    @NotNull
    private int estimatedTime;

    public Distance() {

    }
}
