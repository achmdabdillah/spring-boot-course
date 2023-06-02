package com.abdillah.catalog.repository.impl;

import org.springframework.stereotype.Service;

import com.abdillah.catalog.domain.Author;
import com.abdillah.catalog.dto.AuthorResponseDTO;
import com.abdillah.catalog.exception.BadRequestException;
import com.abdillah.catalog.repository.AuthorRepository;
import com.abdillah.catalog.service.AuthorService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public AuthorResponseDTO findAuthorById(Long id) {
        // TODO
        // 1. fetch data from database
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Invalid authorId"));
        // 2. transfrom Author to authorResponseDto
        AuthorResponseDTO dto = new AuthorResponseDTO();
        dto.setAuthorName(author.getName());
        dto.setBirthDate(author.getBirthDate().toEpochDay());
        return dto;
    }
}
