package com.graphql.graphqldemoproject.response;

import lombok.Data;

@Data
public class StateResponse {
    private String name;
    private String country;
    private CityResponse cityResponse;
}
