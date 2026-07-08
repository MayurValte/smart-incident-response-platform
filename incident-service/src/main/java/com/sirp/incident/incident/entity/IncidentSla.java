package com.sirp.incident.incident.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "incident_sla")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncidentSla {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "incident_id")
    private UUID incidentId;

    private Instant targetResolutionTime;

    private Boolean breached;

    private Instant breachedAt;

}