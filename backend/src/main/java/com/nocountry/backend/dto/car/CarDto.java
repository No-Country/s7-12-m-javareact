package com.nocountry.backend.dto.car;

import com.nocountry.backend.model.Category;
import com.nocountry.backend.model.MediaResource;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {

    private Long id;

    private MediaResource imageResource;

    @Schema(example = "Small Truck")
    private String model;

    @Schema(example = "Peugeot")
    private String make;

    @Schema(example = "2022")
    private Integer year;

    @Schema(example = "true")
    private Boolean air;

    @Schema(example = "true")
    private Boolean gps;

    @Schema(example = "2")
    private Integer passengers;

    @Schema(example = "ABC456")
    private String patent;

    @Schema(example = "6000")
    private Integer length;

    @Schema(example = "2200")
    private Integer width;

    @Schema(example = "2400")
    private Integer height;

    @Schema(example = "02000010")
    private String idLocation;

    @Schema(example = "1")
    private Category category;
}