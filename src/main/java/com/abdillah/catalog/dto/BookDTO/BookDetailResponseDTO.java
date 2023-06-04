package com.abdillah.catalog.dto.BookDTO;

import java.io.Serializable;

import lombok.Data;

@Data
public class BookDetailResponseDTO implements Serializable {

    private static final long serialVersionUID = -3358288267L;

    private Long bookId;
    private String authorName;
    private String bookTitle;
    private String bookDescription;
}
