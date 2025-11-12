package com.taxipot.backend.domain.concert.dto.response;

public record ConcertPreviewResponse(
        Long id,
        String thumbnail,
        String title,
        String dateTime
) {
}
