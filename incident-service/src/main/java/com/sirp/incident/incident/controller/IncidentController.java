package com.sirp.incident.incident.controller;

import com.sirp.incident.incident.dto.request.AssignIncidentRequest;
import com.sirp.incident.incident.dto.request.CreateIncidentRequest;
import com.sirp.incident.incident.dto.request.ResolveIncidentRequest;
import com.sirp.incident.incident.dto.request.UpdateIncidentRequest;
import com.sirp.incident.incident.dto.response.IncidentPageResponse;
import com.sirp.incident.incident.dto.response.IncidentResponse;
import com.sirp.incident.incident.service.IncidentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/incidents")
@Tag(name = "Incident API", description = "Incident Management APIs")
public class IncidentController {

    private final IncidentService incidentService;

    @Operation(summary = "Create Incident")
    @PostMapping
    public ResponseEntity<IncidentResponse> createIncident(@RequestBody @Valid CreateIncidentRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(incidentService.createIncident(request));
    }

    @Operation(summary = "Get Incident")
    @GetMapping("/{id}")
    public ResponseEntity<IncidentResponse> getIncident(@PathVariable UUID id) {
        return ResponseEntity.ok(incidentService.getIncident(id));
    }

    @Operation(summary = "Search Incidents")
    @GetMapping
    public ResponseEntity<IncidentPageResponse> searchIncidents(@RequestParam(defaultValue = "0") Integer page,
        @RequestParam(defaultValue = "20") Integer size,
        @RequestParam(required = false) String status,
        @RequestParam(required = false) String severity,
        @RequestParam(required = false) String priority) {
        return ResponseEntity.ok(incidentService.searchIncidents(page, size, status, severity, priority));
    }

    @Operation(summary = "Update Incident")
    @PutMapping("/{id}")
    public ResponseEntity<IncidentResponse> updateIncident(@PathVariable UUID id,
        @RequestBody @Valid UpdateIncidentRequest request) {
        return ResponseEntity.ok(incidentService.updateIncident(id, request));
    }

    @Operation(summary = "Assign Incident")
    @PutMapping("/{id}/assign")
    public ResponseEntity<IncidentResponse> assignIncident(@PathVariable UUID id,
        @RequestBody @Valid AssignIncidentRequest request) {
        return ResponseEntity.ok(incidentService.assignIncident(id, request));
    }

    @Operation(summary = "Resolve Incident")
    @PutMapping("/{id}/resolve")
    public ResponseEntity<IncidentResponse> resolveIncident(@PathVariable UUID id,
        @RequestBody @Valid ResolveIncidentRequest request) {
        return ResponseEntity.ok(incidentService.resolveIncident(id, request));
    }

    @Operation(summary = "Close Incident")
    @PutMapping("/{id}/close")
    public ResponseEntity<IncidentResponse> closeIncident(@PathVariable UUID id) {
        return ResponseEntity.ok(incidentService.closeIncident(id));
    }

    @PutMapping("/{id}/start")
    public ResponseEntity<IncidentResponse> startIncident(@PathVariable UUID id) {
        return ResponseEntity.ok(incidentService.startIncident(id));
    }
}