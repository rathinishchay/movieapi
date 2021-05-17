/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springdemo.restapi.model;

import lombok.*;

import java.util.List;

/**
 *
 * @author nishc
 */



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MovieResponse {
    private String name;
    private String genre;
    private String language;
    private List<CastResponse> castResponse;
    private List<AwardResponse> awards;
}