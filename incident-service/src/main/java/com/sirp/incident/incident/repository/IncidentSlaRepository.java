package com.sirp.incident.incident.repository;

import com.sirp.incident.incident.entity.IncidentSla;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentSlaRepository extends JpaRepository<IncidentSla, UUID> {

    Optional<IncidentSla> findByIncidentId(UUID incidentId);

}