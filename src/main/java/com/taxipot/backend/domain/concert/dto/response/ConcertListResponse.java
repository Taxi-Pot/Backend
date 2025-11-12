package com.taxipot.backend.domain.concert.dto.response;

import java.util.List;

public record ConcertListResponse(
        List<ConcertPreviewResponse> concertList
) {
}
