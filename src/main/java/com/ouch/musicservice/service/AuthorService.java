package com.ouch.musicservice.service;

import com.ouch.musicservice.model.Author;
import com.ouch.musicservice.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

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
        Author authorFromDB = authorRepository.findById(authorId).orElseThrow();
        authorFromDB.setFirstName(updatedAuthor.getFirstName());
        authorFromDB.setLastName(updatedAuthor.getLastName());
        authorFromDB.setBirthDate(updatedAuthor.getBirthDate());

//        authorFromDB.getSongs().forEach(song -> songService.deleteSongById(authorId, song.getId()));
        authorFromDB.setSongs(updatedAuthor.getSongs());
    }

    public void deleteAuthorById(Long authorId) {
        authorRepository.deleteById(authorId);
    }
}
