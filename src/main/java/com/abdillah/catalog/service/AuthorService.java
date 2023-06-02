package com.abdillah.catalog.service;

import java.util.List;
import com.abdillah.catalog.dto.AuthorCreateRequestDto;
import com.abdillah.catalog.dto.AuthorResponseDTO;

public interface AuthorService {
    public AuthorResponseDTO findAuthorById(Long id);

    public void createNewAuthor(List<AuthorCreateRequestDto> dto);
}
