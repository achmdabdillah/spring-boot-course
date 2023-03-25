package com.abdillah.catalog.repository;

import com.abdillah.catalog.domain.Book;

public interface BookRepository {
    public Book findBookById(Long id);
}
