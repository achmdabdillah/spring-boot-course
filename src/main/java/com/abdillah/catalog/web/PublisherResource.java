package com.abdillah.catalog.web;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abdillah.catalog.domain.Publisher;
import com.abdillah.catalog.dto.PublisherDTO.PublisherCreateRequestDTO;
import com.abdillah.catalog.dto.PublisherDTO.PublisherUpdateRequestDTO;
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

    // Update publisher
    @PutMapping("/v1/publisher/{publisherId}")
    public ResponseEntity<Void> updateAuthor(@PathVariable String publisherId,
            @RequestBody PublisherUpdateRequestDTO dto) {
        publisherService.updatePublisher(publisherId, dto);
        return ResponseEntity.ok().build();
        // authorService.updateAuthor(authorId, dto);
    }
}
