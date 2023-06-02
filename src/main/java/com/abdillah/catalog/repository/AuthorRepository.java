package com.abdillah.catalog.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abdillah.catalog.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    // method name convention
    // find + keyword
    // sql -> select * from Author a where a.id = :authorId
    public Optional<Author> findById(long id);

    // sql -> select * from Author a where a.id = :authorId AND deleted = false
    public Optional<Author> findByIdAndDeletedFalse(long id);

    // sql -> select a from Author a where a.name
    public List<Author> findByNameLike(String name);
}
