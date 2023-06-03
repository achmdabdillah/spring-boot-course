package com.abdillah.catalog.service;

import java.util.List;

import com.abdillah.catalog.dto.BookCreateDto;
import com.abdillah.catalog.dto.BookDetailDto;
import com.abdillah.catalog.dto.BookUpdateRequestDto;

public interface BookService {
    public BookDetailDto findBookDetailById(Long bookId);

    public List<BookDetailDto> findBookListDetail();

    public void createNewBook(BookCreateDto dto);

    public void updateBook(Long bookId, BookUpdateRequestDto dto);

    public void deleteBook(Long bookId);
}
