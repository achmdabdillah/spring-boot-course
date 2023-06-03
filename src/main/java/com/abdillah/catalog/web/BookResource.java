package com.abdillah.catalog.web;

import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.abdillah.catalog.dto.BookDetailDTO;
import com.abdillah.catalog.service.BookService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
public class BookResource {

    private final BookService bookService;

    @GetMapping("/book/{bookId}")
    public BookDetailDTO findBookDetail(@PathVariable("bookId") Long id) {
        StopWatch stopWatch = new StopWatch();

        log.info("START findBookDetail {}", id);
        stopWatch.start();
        BookDetailDTO result = bookService.findBookDetailById(id);
        log.info("FINISH findBookDetail. execution time = {}", stopWatch.getTotalTimeMillis());

        return result;
    }
}
