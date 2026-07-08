package com.sirp.incident.incident.mapper;

import com.sirp.incident.incident.dto.response.AssignmentResponse;
import com.sirp.incident.incident.entity.IncidentAssignment;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssignmentMapper {

    AssignmentResponse toResponse(IncidentAssignment assignment);

    List<AssignmentResponse> toResponseList(List<IncidentAssignment> assignments);

}