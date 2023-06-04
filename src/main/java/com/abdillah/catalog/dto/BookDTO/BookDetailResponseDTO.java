package com.abdillah.catalog.dto.BookDTO;

import java.io.Serializable;
import java.util.List;

import com.abdillah.catalog.dto.AuthorDTO.AuthorResponseDTO;
import com.abdillah.catalog.dto.CategoryDTO.CategoryListResponseDTO;
import com.abdillah.catalog.dto.PublisherDTO.PublisherResponseDTO;

import lombok.Data;

@Data
public class BookDetailResponseDTO implements Serializable {

    private static final long serialVersionUID = -3358288267L;

    private String bookId;
    private List<AuthorResponseDTO> authors;
    private List<CategoryListResponseDTO> categories;
    private PublisherResponseDTO publisher;
    private String bookTitle;
    private String bookDescription;
}
