package com.springdemo.restapi.entity;

import lombok.*;


import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder


@Entity(name = "movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name",nullable = false)
    private String movieName;
    private String genre;
    private String language;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Cast> casts;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Award> awards;
}
