package com.sirp.incident.incident.dto.response;

import java.util.List;

public record IncidentPageResponse(

        List<IncidentSummaryResponse> content,

        int page,

        int size,

        long totalElements,

        int totalPages,

        boolean first,

        boolean last

) {
}