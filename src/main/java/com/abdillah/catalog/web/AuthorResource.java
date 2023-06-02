package com.abdillah.catalog.web;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abdillah.catalog.dto.AuthorCreateRequestDto;
import com.abdillah.catalog.dto.AuthorResponseDTO;
import com.abdillah.catalog.dto.AuthorUpdateRequestDto;
import com.abdillah.catalog.service.AuthorService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class AuthorResource {

    private final AuthorService authorService;

    // get author detail
    @GetMapping("/author/{id}/detail")
    public ResponseEntity<AuthorResponseDTO> findAuthorById(@PathVariable Long id) {
        return ResponseEntity.ok().body(authorService.findAuthorById(id));
    }

    // Insert new author
    @PostMapping("/author")
    public ResponseEntity<Void> createNewAuthor(@RequestBody @Valid List<AuthorCreateRequestDto> dtos) {
        authorService.createNewAuthor(dtos);
        return ResponseEntity.created(URI.create("/author")).build();
    }

    // Update author
    @PutMapping("/author/{authorId}")
    public ResponseEntity<Void> updateAuthor(@PathVariable Long authorId, @RequestBody AuthorUpdateRequestDto dto) {
        authorService.updateAuthor(authorId, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/author/{authorId}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long authorId) {
        authorService.deleteAuthor(authorId);
        return ResponseEntity.ok().build();
    }
}
