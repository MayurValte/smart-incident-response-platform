package com.sirp.incident.incident.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "incident_attachment")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IncidentAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "incident_id")
    private UUID incidentId;

    private String fileName;

    private String contentType;

    private Long fileSize;

    private String storageUrl;

    private UUID uploadedBy;

    private Instant uploadedAt;

}