package com.abdillah.catalog.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.abdillah.catalog.dto.BookDetailDto;
import com.abdillah.catalog.service.BookService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@RestController
public class BookResource {

    private final BookService bookService;

    @GetMapping("/book/{bookId}")
    public BookDetailDto findBookDetail(@PathVariable("bookId") Long id) {
        StopWatch stopWatch = new StopWatch();

        log.info("START findBookDetail {}", id);
        stopWatch.start();
        BookDetailDto result = bookService.findBookDetailById(id);
        log.info("FINISH findBookDetail. execution time = {}", stopWatch.getTotalTimeMillis());

        return result;
    }
}
