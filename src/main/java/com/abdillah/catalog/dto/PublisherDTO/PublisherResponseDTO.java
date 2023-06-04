package com.abdillah.catalog.dto.PublisherDTO;

import java.io.Serializable;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PublisherResponseDTO implements Serializable {

    private static final long serialVersionUID = 9179274204L;

    private String publisherId;

    private String publisherName;
}
