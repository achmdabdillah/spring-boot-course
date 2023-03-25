package com.abdillah.catalog.repository.impl;

import java.util.Map;

import com.abdillah.catalog.domain.Book;

import com.abdillah.catalog.repository.BookRepository;

import lombok.Data;

@Data
public class BookRepositoryImpl implements BookRepository {

    private Map<Long, Book> bookMap;

    @Override
    public Book findBookById(Long id) {
        Book book = bookMap.get(id);
        return book;
    }
}
