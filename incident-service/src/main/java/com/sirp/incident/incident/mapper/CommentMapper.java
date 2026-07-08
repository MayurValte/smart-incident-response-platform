package com.sirp.incident.incident.mapper;

import com.sirp.incident.incident.dto.response.CommentResponse;
import com.sirp.incident.incident.entity.IncidentComment;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentResponse toResponse(IncidentComment comment);

    List<CommentResponse> toResponseList(List<IncidentComment> comments);
}