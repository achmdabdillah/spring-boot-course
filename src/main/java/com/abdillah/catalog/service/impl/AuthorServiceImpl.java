package com.abdillah.catalog.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.abdillah.catalog.domain.Author;
import com.abdillah.catalog.dto.AuthorDTO.AuthorCreateRequestDTO;
import com.abdillah.catalog.dto.AuthorDTO.AuthorResponseDTO;
import com.abdillah.catalog.dto.AuthorDTO.AuthorUpdateRequestDTO;
import com.abdillah.catalog.exception.BadRequestException;
import com.abdillah.catalog.repository.AuthorRepository;
import com.abdillah.catalog.service.AuthorService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public AuthorResponseDTO findAuthorById(String id) {
        // 1. fetch data from database
        Author author = authorRepository.findBySecureId(id)
                .orElseThrow(() -> new BadRequestException("Invalid authorIds"));
        // 2. transfrom Author to authorResponseDto
        AuthorResponseDTO dto = new AuthorResponseDTO();
        dto.setAuthorName(author.getName());
        dto.setBirthDate(author.getBirthDate().toEpochDay());
        return dto;
    }

    @Override
    public void createNewAuthor(List<AuthorCreateRequestDTO> dtos) {
        List<Author> authors = dtos.stream().map((dto) -> {
            Author author = new Author();
            author.setName(dto.getAuthorName());
            author.setBirthDate(LocalDate.ofEpochDay(dto.getBirthDate()));
            return author;
        }).collect(Collectors.toList());

        authorRepository.saveAll(authors);
    }

    @Override
    public void updateAuthor(String authorId, AuthorUpdateRequestDTO dto) {
        Author author = authorRepository.findBySecureId(authorId)
                .orElseThrow(() -> new BadRequestException("Invalid authorId"));
        author.setName(dto.getAuthorName() == null ? author.getName() : dto.getAuthorName());
        author.setBirthDate(
                dto.getBirthDate() == null ? author.getBirthDate() : LocalDate.ofEpochDay(dto.getBirthDate()));

        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(String authorId) {
        Author author = authorRepository.findBySecureId(authorId)
                .orElseThrow(() -> new BadRequestException("Invalid authorId"));

        authorRepository.delete(author);
        // authorRepository.deleteBySecureId(authorId);
    }

}
