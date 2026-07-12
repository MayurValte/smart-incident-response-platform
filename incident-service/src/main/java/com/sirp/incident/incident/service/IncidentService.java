package com.sirp.incident.incident.service;

import com.sirp.incident.incident.dto.request.AssignIncidentRequest;
import com.sirp.incident.incident.dto.request.CreateIncidentRequest;
import com.sirp.incident.incident.dto.request.ResolveIncidentRequest;
import com.sirp.incident.incident.dto.request.UpdateIncidentRequest;
import com.sirp.incident.incident.dto.response.IncidentPageResponse;
import com.sirp.incident.incident.dto.response.IncidentResponse;
import java.util.UUID;

public interface IncidentService {

    IncidentResponse createIncident(CreateIncidentRequest request, UUID actorId);

    IncidentResponse getIncident(UUID id);

    IncidentPageResponse searchIncidents(Integer page, Integer size, String status, String severity, String priority);

    IncidentResponse updateIncident(UUID id, UpdateIncidentRequest request);

    /**
     * actorId is the JWT-verified caller when reached via the public
     * controller, or null when triggered internally by workflow-service
     * (Feign calls carry no JWT) - callers should fall back to a sensible
     * default rather than fabricate an actor.
     */
    IncidentResponse assignIncident(UUID id, AssignIncidentRequest request, UUID actorId);

    IncidentResponse resolveIncident(UUID id, ResolveIncidentRequest request, UUID actorId);

    IncidentResponse closeIncident(UUID id, UUID actorId);

    IncidentResponse startIncident(UUID id, UUID actorId);
}