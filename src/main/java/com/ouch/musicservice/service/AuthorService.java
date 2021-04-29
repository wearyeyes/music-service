package com.ouch.musicservice.service;

import com.ouch.musicservice.model.Author;
import com.ouch.musicservice.repository.AlbumRepository;
import com.ouch.musicservice.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private AlbumRepository albumRepository;

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    };

    public Author getAuthorById(Long authorId) {
        return authorRepository.findById(authorId).orElseThrow();
    }

    public void createNewAuthor(Author newAuthor) {
        newAuthor.getAlbums().forEach(album -> albumRepository.save(album));
        authorRepository.save(newAuthor);
    }

    @Transactional
    public void updateAuthorById(Long authorId, Author updatedAuthor) {
        Author authorFromBD = authorRepository.findById(authorId).orElseThrow();
        authorFromBD.setFirstName(updatedAuthor.getFirstName());
        authorFromBD.setLastName(updatedAuthor.getLastName());
        authorFromBD.setBirthDate(updatedAuthor.getBirthDate());
        authorFromBD.setAlbums(updatedAuthor.getAlbums());
    }

    public void deleteAuthorById(Long authorId) {
        authorRepository.deleteById(authorId);
    }
}
