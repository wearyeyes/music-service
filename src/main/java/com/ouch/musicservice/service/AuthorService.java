package com.ouch.musicservice.service;

import com.ouch.musicservice.model.Author;
import com.ouch.musicservice.repository.AlbumRepository;
import com.ouch.musicservice.repository.AuthorRepository;
import com.ouch.musicservice.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private SongRepository songRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    };

    public Author getAuthorById(Long authorId) {
        return authorRepository.findById(authorId).orElseThrow();
    }

    public void createNewAuthor(Author newAuthor) {
        authorRepository.save(newAuthor);
    }

    @Transactional
    public void updateAuthorById(Long authorId, Author updatedAuthor) {

    }

    public void deleteAuthorById(Long authorId) {
        authorRepository.deleteById(authorId);
    }


}
