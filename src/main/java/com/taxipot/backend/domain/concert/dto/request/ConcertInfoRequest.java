package com.taxipot.backend.domain.concert.dto.request;

import java.time.LocalDateTime;

public record ConcertInfoRequest(
        String thumbnail,
        String title,
        LocalDateTime dateTime
) {
}
