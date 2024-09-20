package com.knu.daeguhackathon.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Subject {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @NotNull
    private String courseName;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @NotNull
    @OneToOne
    @JoinColumn(name = "building_id")
    private Building building;

    public Subject() {

    }
}
