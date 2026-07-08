package com.sirp.incident.incident.repository;

import com.sirp.incident.incident.entity.IncidentAttachment;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentAttachmentRepository extends JpaRepository<IncidentAttachment, UUID> {

    List<IncidentAttachment> findByIncidentId(UUID incidentId);

}