package com.janwee.bookstore.authorserver.application;


import com.janwee.bookstore.authorserver.domain.Author;
import com.janwee.bookstore.authorserver.domain.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorApplicationService {
    private final AuthorRepository authorRepo;

    @Autowired
    public AuthorApplicationService(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    public Optional<Author> author(Long id) {
        return authorRepo.findById(id);
    }

    public void add(Author author) {
        authorRepo.save(author);
    }
}