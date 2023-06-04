package com.abdillah.catalog.dto.BookDTO;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Data
public class BookCreateRequestDTO implements Serializable {

    private static final long serialVersionUID = -8116198073L;

    @NotBlank
    private String bookTitle;

    @NotEmpty
    private List<String> authorIdList;

    @NotEmpty
    private List<String> categoryList;

    @NotBlank
    private String publisherId;

    @JsonProperty("synopsis")
    private String description;
}
