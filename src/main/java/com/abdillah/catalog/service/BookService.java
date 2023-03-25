package com.abdillah.catalog.service;

import com.abdillah.catalog.dto.BookDetailDto;

public interface BookService {
    public BookDetailDto findBookDetailById(Long bookId);
}
