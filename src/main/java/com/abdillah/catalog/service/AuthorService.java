package com.abdillah.catalog.service;

import java.util.List;

import com.abdillah.catalog.domain.Author;
import com.abdillah.catalog.dto.AuthorDTO.AuthorCreateRequestDTO;
import com.abdillah.catalog.dto.AuthorDTO.AuthorResponseDTO;
import com.abdillah.catalog.dto.AuthorDTO.AuthorUpdateRequestDTO;

public interface AuthorService {
    public AuthorResponseDTO findAuthorById(String id);

    public void createNewAuthor(List<AuthorCreateRequestDTO> dto);

    public void updateAuthor(String authorId, AuthorUpdateRequestDTO dto);

    public void deleteAuthor(String authorId);

    public List<Author> findAuthors(List<String> authorIdList);

    public List<AuthorResponseDTO> constructDTO(List<Author> authors);
}
