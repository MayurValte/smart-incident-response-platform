package com.sirp.incident.incident.repository;

import com.sirp.incident.incident.entity.IncidentHistory;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentHistoryRepository extends JpaRepository<IncidentHistory, UUID> {

    List<IncidentHistory> findByIncidentIdOrderByChangedAtDesc(UUID incidentId);
}