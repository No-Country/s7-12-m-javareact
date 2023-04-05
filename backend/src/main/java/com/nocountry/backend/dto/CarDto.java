package com.nocountry.backend.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.nocountry.backend.model.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("image")
    private String image;

    @JsonProperty("model")
    private String model;

    @JsonProperty("make")
    private String make;

    @JsonProperty("year")
    private int year;

    @JsonProperty("air")
    private boolean air;

    @JsonProperty("gps")
    private boolean gps;

    @JsonProperty("passengers")
    private Integer passengers;

    @JsonProperty("patent")
    private String patent;

    @JsonProperty("Available")
    private boolean available;

    @JsonProperty("category")
    private Category category;
}