package com.abdillah.catalog.dto.CategoryDTO;

import java.io.Serializable;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Data;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CategoryListResponseDTO implements Serializable {

    private static final long serialVersionUID = 22001728L;

    private String code;

    private String name;

    private String description;

}
