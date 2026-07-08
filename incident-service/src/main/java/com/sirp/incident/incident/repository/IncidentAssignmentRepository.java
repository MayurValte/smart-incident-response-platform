package com.sirp.incident.incident.repository;

import com.sirp.incident.incident.entity.IncidentAssignment;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentAssignmentRepository extends JpaRepository<IncidentAssignment, UUID> {

    List<IncidentAssignment> findByIncidentIdOrderByAssignedAtDesc(UUID incidentId);

}