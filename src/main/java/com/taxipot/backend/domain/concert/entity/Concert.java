package com.taxipot.backend.domain.concert.entity;

import com.taxipot.backend.domain.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Concert extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String title;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @Builder
    public Concert(String image, String title, LocalDateTime dateTime) {
        this.image = image;
        this.title = title;
        this.dateTime = dateTime;
    }
}
