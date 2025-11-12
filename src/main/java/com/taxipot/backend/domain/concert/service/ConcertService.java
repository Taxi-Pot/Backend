package com.taxipot.backend.domain.concert.service;

import com.taxipot.backend.domain.concert.dto.request.ConcertInfoRequest;
import com.taxipot.backend.domain.concert.dto.response.ConcertListResponse;
import com.taxipot.backend.domain.concert.dto.response.ConcertPreviewResponse;
import com.taxipot.backend.domain.concert.entity.Concert;
import com.taxipot.backend.domain.concert.repository.ConcertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConcertService {

    private final ConcertRepository concertRepository;

    public void createConcert(ConcertInfoRequest infoRequest) {

        Concert concert = Concert.builder()
                .image(infoRequest.thumbnail())
                .title(infoRequest.title())
                .dateTime(infoRequest.dateTime())
                .build();
        concertRepository.save(concert);
    }

    public ConcertListResponse getConcertList() {
        List<Concert> concerts = concertRepository.findAll();

        List<ConcertPreviewResponse> previews = concerts.stream()
                .sorted(Comparator.comparing(Concert::getDateTime))
                .map(concert -> new ConcertPreviewResponse(
                        concert.getId(),
                        concert.getImage(),
                        concert.getTitle(),
                        concert.getDateTime().toString()
                ))
                .collect(Collectors.toList());

        return new ConcertListResponse(previews);
    }

}
