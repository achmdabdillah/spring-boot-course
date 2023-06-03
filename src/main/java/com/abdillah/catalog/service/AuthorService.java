package com.abdillah.catalog.service;

import java.util.List;
import com.abdillah.catalog.dto.AuthorCreateRequestDTO;
import com.abdillah.catalog.dto.AuthorResponseDTO;
import com.abdillah.catalog.dto.AuthorUpdateRequestDTO;

public interface AuthorService {
    public AuthorResponseDTO findAuthorById(Long id);

    public void createNewAuthor(List<AuthorCreateRequestDTO> dto);

    public void updateAuthor(Long authorId, AuthorUpdateRequestDTO dto);

    public void deleteAuthor(Long authorId);
}
