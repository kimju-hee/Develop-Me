package com.example.Develop_Me.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Entity
@Table(name = "RECURRING")
public class Recurring {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recurringId;

    @Column(length = 10)
    private String recurringType;

    @Column(length = 100)
    private String recurringInformation;
}
