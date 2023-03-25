package com.abdillah.catalog.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class BookDetailDto implements Serializable {
    private Long bookId;
    private String authorName;
    private String bookTitle;
    private String bookDescription;
}
