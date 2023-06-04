package com.abdillah.catalog.web;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abdillah.catalog.dto.BookDTO.BookCreateRequestDTO;
import com.abdillah.catalog.dto.BookDTO.BookDetailResponseDTO;
import com.abdillah.catalog.service.BookService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
public class BookResource {

    private final BookService bookService;

    @GetMapping("/v1/book/{bookId}")
    public ResponseEntity<BookDetailResponseDTO> findBookDetail(@PathVariable("bookId") String id) {
        StopWatch stopWatch = new StopWatch();

        log.info("START findBookDetail {}", id);
        stopWatch.start();
        BookDetailResponseDTO result = bookService.findBookDetailById(id);
        log.info("FINISH findBookDetail. execution time = {}", stopWatch.getTotalTimeMillis());
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/v1/book")
    public ResponseEntity<Void> createNewAuthor(@RequestBody BookCreateRequestDTO dto) {
        bookService.createNewBook(dto);
        return ResponseEntity.created(URI.create("/book")).build();
    }
}
