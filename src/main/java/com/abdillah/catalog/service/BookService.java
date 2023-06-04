package com.abdillah.catalog.service;

import java.util.List;

import com.abdillah.catalog.dto.BookDTO.BookCreateRequestDTO;
import com.abdillah.catalog.dto.BookDTO.BookDetailResponseDTO;
import com.abdillah.catalog.dto.BookDTO.BookUpdateRequestDTO;

public interface BookService {
    public BookDetailResponseDTO findBookDetailById(String bookId);

    public List<BookDetailResponseDTO> findBookListDetail();

    public void createNewBook(BookCreateRequestDTO dto);

    public void updateBook(String bookId, BookUpdateRequestDTO dto);

    public void deleteBook(String bookId);
}
