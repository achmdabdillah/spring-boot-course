package com.abdillah.catalog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.abdillah.catalog.domain.Author;
import com.abdillah.catalog.domain.Book;
import com.abdillah.catalog.dto.BookDTO.BookCreateDTO;
import com.abdillah.catalog.dto.BookDTO.BookDetailDTO;
import com.abdillah.catalog.dto.BookDTO.BookUpdateRequestDTO;
import com.abdillah.catalog.exception.BadRequestException;
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
    public BookDetailDTO findBookDetailById(Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BadRequestException("book_id.invalid"));
        BookDetailDTO dto = new BookDetailDTO();
        dto.setBookId(book.getId());
        // dto.setAuthorName(book.getAuthor().getName());
        dto.setBookTitle(book.getTitle());
        dto.setBookDescription(book.getDescription());

        return dto;
    }

    @Override
    public List<BookDetailDTO> findBookListDetail() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map((book) -> {
            BookDetailDTO dto = new BookDetailDTO();
            // dto.setAuthorName(book.getAuthor().getName());
            dto.setBookDescription(book.getDescription());
            dto.setBookId(book.getId());
            dto.setBookTitle(book.getTitle());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void createNewBook(BookCreateDTO dto) {
        Author author = new Author();
        author.setName(dto.getAuthorName());

        Book book = new Book();
        // book.setAuthor(author);
        book.setTitle(dto.getBooktitle());
        book.setDescription(dto.getDescription());
        bookRepository.save(book);
    }

    @Override
    public void updateBook(Long bookId, BookUpdateRequestDTO dto) {
        // get book from repository
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new BadRequestException("book_id.invalid"));
        // update
        book.setTitle(dto.getBooktitle());
        book.setDescription(dto.getDescription());
        // save
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    // public BookRepository getBookRepository() {
    // return this.bookRepository;
    // }

    // public void setBookRepository(BookRepository bookRepository) {
    // this.bookRepository = bookRepository;
    // }

}
