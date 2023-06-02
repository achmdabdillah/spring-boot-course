package com.abdillah.catalog.service;

import com.abdillah.catalog.dto.AuthorResponseDTO;

public interface AuthorService {
    public AuthorResponseDTO findAuthorById(Long id);
}
