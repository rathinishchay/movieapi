package com.springdemo.restapi.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder


@Entity(name = "award")
public class Award {
    @Id
    @GeneratedValue
    Long id;
    @Column(name = "name",nullable = false)
    private String name;
    private String year;
}
