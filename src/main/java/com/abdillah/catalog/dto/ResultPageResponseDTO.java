package com.abdillah.catalog.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class ResultPageResponseDTO<T> implements Serializable {

    private static final long serialVersionUID = 4309854218L;

    private List<T> result;

    private Integer pages;

    private Long elements;
}
