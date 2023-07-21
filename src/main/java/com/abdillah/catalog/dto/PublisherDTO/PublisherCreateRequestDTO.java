package com.abdillah.catalog.dto.PublisherDTO;

import java.io.Serializable;

import com.abdillah.catalog.annotation.LogThisArg;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

// @LogThisArg
@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublisherCreateRequestDTO implements Serializable {

    private static final long serialVersionUID = -3865115382L;

    @NotBlank
    private String publisherName;

    @NotBlank
    private String companyName;

    private String address;
}
