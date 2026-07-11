package com.sirp.workflow.entity;

import com.sirp.common.enums.IncidentSeverity;
import com.sirp.common.enums.WorkflowStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(
    name = "workflow",
    indexes = {
        @Index(name = "idx_workflow_incident_id", columnList = "incident_id"),
        @Index(name = "idx_workflow_status", columnList = "workflow_status"),
        @Index(name = "idx_workflow_assigned_to", columnList = "assigned_to"),
        @Index(name = "idx_workflow_next_escalation", columnList = "next_escalation_time")
    }
)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkflowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "incident_id", nullable = false, unique = true)
    private UUID incidentId;

    @Column(name = "assigned_to")
    private UUID assignedTo;

    @Column(name = "assigned_team")
    private UUID assignedTeam;

    @Enumerated(EnumType.STRING)
    @Column(name = "workflow_status", nullable = false, length = 30)
    private WorkflowStatus workflowStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "severity", nullable = false, length = 20)
    private IncidentSeverity severity;

    @Column(name = "escalation_level", nullable = false)
    @Builder.Default
    private Integer escalationLevel = 0;

    @Column(name = "sla_deadline", nullable = false)
    private Instant slaDeadline;

    @Column(name = "next_escalation_time")
    private Instant nextEscalationTime;

    @Column(name = "resolved_at")
    private Instant resolvedAt;

    @Column(name = "closed_at")
    private Instant closedAt;

    @Column(name = "remarks", length = 1000)
    private String remarks;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    @PrePersist
    public void prePersist() {
        Instant now = Instant.now();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = Instant.now();
    }

}