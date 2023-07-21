package com.abdillah.catalog.web;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abdillah.catalog.annotation.LogThisMethod;
import com.abdillah.catalog.domain.Publisher;
import com.abdillah.catalog.dto.ResultPageResponseDTO;
import com.abdillah.catalog.dto.PublisherDTO.PublisherCreateRequestDTO;
import com.abdillah.catalog.dto.PublisherDTO.PublisherListResponseDTO;
import com.abdillah.catalog.dto.PublisherDTO.PublisherUpdateRequestDTO;
import com.abdillah.catalog.exception.BadRequestException;
import com.abdillah.catalog.service.PublisherService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class PublisherResource {
    private final PublisherService publisherService;

    // Insert new publisher
    @PostMapping("/v1/publisher")
    public ResponseEntity<Publisher> createNewPublisher(@RequestBody @Valid PublisherCreateRequestDTO dto) {
        Publisher publisher = publisherService.createPublisher(dto);
        return ResponseEntity.created(URI.create("/v1/publisher")).body(publisher);
    }

    // Get publisher
    @GetMapping("/v1/publisher/{publisherId}")
    public ResponseEntity<Publisher> createNewPublisher(@PathVariable String publisherId) {
        return ResponseEntity.created(URI.create("/v1/publisher")).body(publisherService.findPublisher(publisherId));
    }

    // Update publisher
    @PutMapping("/v1/publisher/{publisherId}")
    public ResponseEntity<Void> updateAuthor(@PathVariable String publisherId,
            @RequestBody PublisherUpdateRequestDTO dto) {
        publisherService.updatePublisher(publisherId, dto);
        return ResponseEntity.ok().build();
        // authorService.updateAuthor(authorId, dto);
    }

    @LogThisMethod
    @GetMapping("/v1/publisher")
    public ResponseEntity<ResultPageResponseDTO<PublisherListResponseDTO>> findPublisherList(
            @RequestParam(name = "pages", required = true, defaultValue = "0") Integer pages,
            @RequestParam(name = "limit", required = true, defaultValue = "10") Integer limit,
            @RequestParam(name = "sortBy", required = true, defaultValue = "name") String sortBy,
            @RequestParam(name = "direction", required = true, defaultValue = "asc") String direction,
            @RequestParam(name = "publisherName", required = false) String publisherName) {
        if (pages < 0)
            throw new BadRequestException("invalid pages");
        return ResponseEntity.ok()
                .body(publisherService.findPublisherList(pages, limit, sortBy, direction, publisherName));
    }
}
