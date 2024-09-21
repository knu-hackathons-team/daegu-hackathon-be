package com.knu.daeguhackathon.building;

import com.knu.daeguhackathon.subject.Subject;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Building {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotNull
    private String buildingName;
    @NotNull
    private Double latitude;
    @NotNull
    private Double longitude;
    @NotNull
    @OneToOne
    private Subject subject;
}
