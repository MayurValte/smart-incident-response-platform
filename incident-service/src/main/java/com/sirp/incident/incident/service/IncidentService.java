package com.sirp.incident.incident.service;

import com.sirp.incident.incident.dto.request.AssignIncidentRequest;
import com.sirp.incident.incident.dto.request.CreateIncidentRequest;
import com.sirp.incident.incident.dto.request.ResolveIncidentRequest;
import com.sirp.incident.incident.dto.request.UpdateIncidentRequest;
import com.sirp.incident.incident.dto.response.IncidentPageResponse;
import com.sirp.incident.incident.dto.response.IncidentResponse;
import java.util.UUID;

public interface IncidentService {

    IncidentResponse createIncident(CreateIncidentRequest request);

    IncidentResponse getIncident(UUID id);

    IncidentPageResponse searchIncidents(Integer page, Integer size, String status, String severity, String priority);

    IncidentResponse updateIncident(UUID id, UpdateIncidentRequest request);

    IncidentResponse assignIncident(UUID id, AssignIncidentRequest request);

    IncidentResponse resolveIncident(UUID id, ResolveIncidentRequest request);

    IncidentResponse closeIncident(UUID id);

    IncidentResponse startIncident(UUID id);
}