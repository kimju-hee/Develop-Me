package com.example.Develop_Me.entity;

import java.util.Set;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "CATEGORY")
public class Category {

    @Id
    private Long cateId;

    @Column(length = 45)
    private String cateName;

    @OneToMany(mappedBy = "category")
    private Set<Users> users;

    


}
