package com.sirp.incident.incident.repository;

import com.sirp.incident.incident.entity.IncidentComment;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentCommentRepository extends JpaRepository<IncidentComment, UUID> {

    List<IncidentComment> findByIncidentIdOrderByCreatedAtAsc(UUID incidentId);
}