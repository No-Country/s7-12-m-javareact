package com.nocountry.backend.model.dto.customer;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.nocountry.backend.model.dto.card.CardSaveDto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRegisterDto {

    @Schema(example = "userr@test.com")
    private String email;

    @Schema(example = "1234")
    private String password;

    @Schema(example = "User Test")
    private String fullName;

    @Schema(example = "Calle sin nombre 123, Buenos Aires")
    private String address;

    @Schema(example = "44332244")
    private String dni;

    @Schema(example = "34533355")
    private String numberLicence;

    @Schema(example = "2023-01-15T12:00:00")
    private LocalDateTime dateExpiration;

    @Schema(example = "02000010")
    private String idLocation;

    @JsonIgnore
    private Long fkUser;

    private CardSaveDto card;
}