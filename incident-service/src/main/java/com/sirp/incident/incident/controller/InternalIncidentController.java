package com.sirp.incident.incident.controller;

import com.sirp.incident.incident.dto.request.AssignIncidentRequest;
import com.sirp.incident.incident.dto.request.ResolveIncidentRequest;
import com.sirp.incident.incident.dto.response.IncidentResponse;
import com.sirp.incident.incident.service.IncidentService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/internal/incidents")
public class InternalIncidentController {

    private final IncidentService incidentService;

    @GetMapping("/{id}")
    public ResponseEntity<IncidentResponse> getIncident(@PathVariable UUID id) {
        return ResponseEntity.ok(incidentService.getIncident(id));
    }

    @PutMapping("/{id}/assign")
    public ResponseEntity<IncidentResponse> assignIncident(@PathVariable UUID id,
        @RequestBody AssignIncidentRequest request) {
        // No JWT on internal Feign calls - workflow-service is the actual actor here,
        // but its identity isn't forwarded. The service falls back to a sensible default.
        return ResponseEntity.ok(incidentService.assignIncident(id, request, null));
    }

    @PutMapping("/{id}/start")
    public ResponseEntity<IncidentResponse> startIncident(@PathVariable UUID id) {
        return ResponseEntity.ok(incidentService.startIncident(id, null));
    }

    @PutMapping("/{id}/resolve")
    public ResponseEntity<IncidentResponse> resolveIncident(@PathVariable UUID id,
        @RequestBody ResolveIncidentRequest request) {
        return ResponseEntity.ok(incidentService.resolveIncident(id, request, null));
    }

    @PutMapping("/{id}/close")
    public ResponseEntity<IncidentResponse> closeIncident(@PathVariable UUID id) {
        return ResponseEntity.ok(incidentService.closeIncident(id, null));
    }
}