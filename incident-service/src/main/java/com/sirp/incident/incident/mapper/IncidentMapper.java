package com.sirp.incident.incident.mapper;

import com.sirp.incident.incident.dto.request.CreateIncidentRequest;
import com.sirp.incident.incident.dto.response.IncidentResponse;
import com.sirp.incident.incident.dto.response.IncidentSummaryResponse;
import com.sirp.incident.incident.entity.Incident;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR, uses = CommentMapper.class)
public interface IncidentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "incidentNumber", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "assignedTo", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "resolvedAt", ignore = true)
    @Mapping(target = "closedAt", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "comments", ignore = true)
    @Mapping(target = "histories", ignore = true)
    Incident toEntity(CreateIncidentRequest request);

    IncidentResponse toResponse(Incident incident);

    IncidentSummaryResponse toSummary(Incident incident);
}