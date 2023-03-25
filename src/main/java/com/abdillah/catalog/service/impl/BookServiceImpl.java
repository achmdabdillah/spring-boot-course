package com.abdillah.catalog.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.abdillah.catalog.domain.Book;
import com.abdillah.catalog.dto.BookDetailDto;
import com.abdillah.catalog.repository.BookRepository;
import com.abdillah.catalog.service.BookService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service("bookService")
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public BookDetailDto findBookDetailById(Long bookId) {
        Book book = bookRepository.findBookById(bookId);
        BookDetailDto dto = new BookDetailDto();
        dto.setBookId(book.getId());
        dto.setAuthorName(book.getAuthor().getName());
        dto.setBookTitle(book.getTitle());
        dto.setBookDescription(book.getDescription());

        return dto;
    }

    // public BookRepository getBookRepository() {
    // return this.bookRepository;
    // }

    // public void setBookRepository(BookRepository bookRepository) {
    // this.bookRepository = bookRepository;
    // }

}
