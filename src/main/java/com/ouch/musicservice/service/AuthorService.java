package com.ouch.musicservice.service;

import com.ouch.musicservice.model.Author;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorService {
    public List<Author> getAllAuthors() {return null;};

    public Author getAuthorById(Long authorId) {return null;}

    public void createNewAuthor() {}

    public void updateAuthorById(Long authorId) {}

    public void deleteAuthorById(Long authorId) {}
}
