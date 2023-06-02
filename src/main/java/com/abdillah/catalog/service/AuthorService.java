package com.abdillah.catalog.service;

import java.util.List;
import com.abdillah.catalog.dto.AuthorCreateRequestDto;
import com.abdillah.catalog.dto.AuthorResponseDTO;
import com.abdillah.catalog.dto.AuthorUpdateRequestDto;

public interface AuthorService {
    public AuthorResponseDTO findAuthorById(Long id);

    public void createNewAuthor(List<AuthorCreateRequestDto> dto);

    public void updateAuthor(Long authorId, AuthorUpdateRequestDto dto);

    public void deleteAuthor(Long authorId);
}
