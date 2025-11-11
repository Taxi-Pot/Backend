package com.taxipot.backend.domain.post.entity;

import com.taxipot.backend.domain.common.entity.BaseEntity;
import com.taxipot.backend.domain.concert.entity.Concert;
import com.taxipot.backend.domain.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String content;

    @Column(name = "meeting_time", nullable = false)
    private String meetingTime;

    @Column(name = "departure_location", nullable = false)
    private String departureLocation;

    @Column(name = "arrival_location", nullable = false)
    private String arrivalLocation;

    @Column(name = "reserved_taxi", nullable = false)
    private String reservedTaxi;

    @Column(name = "max_passengers", nullable = false)
    private String maxPassengers;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private UserEntity author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "concert_id", nullable = false)
    private Concert concert;

    @Builder
    public Post(String title, String content, String meetingTime, String departureLocation,
                String arrivalLocation, String reservedTaxi, String maxPassengers, UserEntity user, Concert concert) {
        this.title = title;
        this.content = content;
        this.meetingTime = meetingTime;
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.reservedTaxi = reservedTaxi;
        this.maxPassengers = maxPassengers;
        this.author = user;
        this.concert = concert;
    }
}
