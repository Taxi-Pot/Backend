package com.taxipot.backend.domain.user.entity;

import com.taxipot.backend.domain.common.entity.BaseEntity;
import com.taxipot.backend.domain.user.enums.Gender;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false)
    private String phoneNumber;

    private String profileImage;

    @Builder
    public UserEntity(String username, Gender gender, Integer age, String phoneNumber, String profileImage) {
        this.username = username;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.profileImage = profileImage;
    }
}
