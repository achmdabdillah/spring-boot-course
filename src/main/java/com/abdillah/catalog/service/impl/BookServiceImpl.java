package com.abdillah.catalog.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.abdillah.catalog.domain.Author;
import com.abdillah.catalog.domain.Book;
import com.abdillah.catalog.domain.Category;
import com.abdillah.catalog.domain.Publisher;
import com.abdillah.catalog.dto.BookDTO.BookCreateRequestDTO;
import com.abdillah.catalog.dto.BookDTO.BookDetailResponseDTO;
import com.abdillah.catalog.dto.BookDTO.BookUpdateRequestDTO;
import com.abdillah.catalog.exception.BadRequestException;
import com.abdillah.catalog.repository.BookRepository;
import com.abdillah.catalog.service.AuthorService;
import com.abdillah.catalog.service.BookService;
import com.abdillah.catalog.service.CategoryService;
import com.abdillah.catalog.service.PublisherService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Service("bookService")
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final PublisherService publisherService;

    @Override
    public BookDetailResponseDTO findBookDetailById(Long bookId) {
        Book book = bookRepository.findBySecureId(bookId).orElseThrow(() -> new BadRequestException("book_id.invalid"));
        BookDetailResponseDTO dto = new BookDetailResponseDTO();
        dto.setBookId(book.getId());
        // dto.setAuthorName(book.getAuthor().getName());
        dto.setBookTitle(book.getTitle());
        dto.setBookDescription(book.getDescription());

        return dto;
    }

    @Override
    public List<BookDetailResponseDTO> findBookListDetail() {
        List<Book> books = bookRepository.findAll();
        return books.stream().map((book) -> {
            BookDetailResponseDTO dto = new BookDetailResponseDTO();
            // dto.setAuthorName(book.getAuthor().getName());
            dto.setBookDescription(book.getDescription());
            dto.setBookId(book.getId());
            dto.setBookTitle(book.getTitle());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public void createNewBook(BookCreateRequestDTO dto) {
        List<Author> authors = authorService.findAuthors(dto.getAuthorIdList());
        List<Category> categories = categoryService.findCategories(dto.getCategoryList());
        Publisher publisher = publisherService.findPublisher(dto.getPublisherId());

        Book book = new Book();
        book.setAuthors(authors);
        book.setCategories(categories);
        book.setPublisher(publisher);
        book.setTitle(dto.getBookTitle());
        book.setDescription(dto.getDescription());

        bookRepository.save(book);
    }

    @Override
    public void updateBook(Long bookId, BookUpdateRequestDTO dto) {
        // get book from repository
        Book book = bookRepository.findBySecureId(bookId).orElseThrow(() -> new BadRequestException("book_id.invalid"));
        // update
        book.setTitle(dto.getBooktitle());
        book.setDescription(dto.getDescription());
        // save
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long bookId) {
        Book book = bookRepository.findBySecureId(bookId).orElseThrow(() -> new BadRequestException("book_id.invalid"));
        bookRepository.delete(book);
    }

    // public BookRepository getBookRepository() {
    // return this.bookRepository;
    // }

    // public void setBookRepository(BookRepository bookRepository) {
    // this.bookRepository = bookRepository;
    // }

}
