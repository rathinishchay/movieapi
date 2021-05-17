package com.springdemo.restapi.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AwardRequest {
    private String name;
    private String year;
}
