package com.taxipot.backend.domain.concert.controller;

import com.taxipot.backend.domain.concert.dto.request.ConcertInfoRequest;
import com.taxipot.backend.domain.concert.dto.response.ConcertListResponse;
import com.taxipot.backend.domain.concert.service.ConcertService;
import com.taxipot.backend.global.common.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ConcertController {

    private final ConcertService concertService;

    @PostMapping("/api/concert")
    public CommonResponse<Void> createConcert(@RequestBody ConcertInfoRequest concertInfoRequest) {
        concertService.createConcert(concertInfoRequest);
        return new CommonResponse<>("콘서트 등록");
    }

    @GetMapping("/api/concert")
    public CommonResponse<ConcertListResponse> getConcertList() {
        ConcertListResponse concertList = concertService.getConcertList();
        return new CommonResponse<>("현재 진행 중인 콘서트 리스트 반환", concertList);
    }
}
