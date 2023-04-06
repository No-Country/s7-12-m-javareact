package com.nocountry.backend.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookingDto {

    private Long id;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String pickUpLocation;

    private String dropOffLocation;

    private Boolean assignedDriver;

    private Boolean helperPawn;

    @JsonProperty("carId")
    private Long fkCar;

    @JsonProperty("customerId")
    private Long fkCustomer;
}
