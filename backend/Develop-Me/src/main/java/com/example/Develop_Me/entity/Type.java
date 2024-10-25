package com.example.Develop_Me.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "TYPE")
public class Type {
    @Id
    private Long typeId;

    @Column(length = 45)
    private String typeName;

    @Column(length = 10)
    private String typeGroup;

    @ManyToOne
    @JoinColumn(name = "userId")
    private Users users;


}
