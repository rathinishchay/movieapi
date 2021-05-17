package com.springdemo.restapi.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AwardResponse {
    private String name;
    private String year;
}
