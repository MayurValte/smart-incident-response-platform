package com.sirp.incident.incident.mapper;

import com.sirp.incident.incident.dto.response.HistoryResponse;
import com.sirp.incident.incident.entity.IncidentHistory;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HistoryMapper {

    HistoryResponse toResponse(IncidentHistory history);

    List<HistoryResponse> toResponseList(List<IncidentHistory> histories);

}