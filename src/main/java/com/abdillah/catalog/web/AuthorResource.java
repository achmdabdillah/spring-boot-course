package com.abdillah.catalog.web;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abdillah.catalog.dto.AuthorDTO.AuthorCreateRequestDTO;
import com.abdillah.catalog.dto.AuthorDTO.AuthorResponseDTO;
import com.abdillah.catalog.dto.AuthorDTO.AuthorUpdateRequestDTO;
import com.abdillah.catalog.service.AuthorService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class AuthorResource {

    private final AuthorService authorService;

    // get author detail
    @GetMapping("/v1/author/{id}/detail")
    public ResponseEntity<AuthorResponseDTO> findAuthorById(@PathVariable String id) {
        return ResponseEntity.ok().body(authorService.findAuthorById(id));
    }

    // Insert new author
    @PostMapping("/v1/author")
    public ResponseEntity<Void> createNewAuthor(@RequestBody @Valid List<AuthorCreateRequestDTO> dtos) {
        authorService.createNewAuthor(dtos);
        return ResponseEntity.created(URI.create("/author")).build();
    }

    // Update author
    @PutMapping("/v1/author/{authorId}")
    public ResponseEntity<Void> updateAuthor(@PathVariable String authorId, @RequestBody AuthorUpdateRequestDTO dto) {
        authorService.updateAuthor(authorId, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/v1/author/{authorId}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable String authorId) {
        authorService.deleteAuthor(authorId);
        return ResponseEntity.ok().build();
    }
}
