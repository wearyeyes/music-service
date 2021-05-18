package com.ouch.musicservice.service;

import com.ouch.musicservice.model.Author;
import com.ouch.musicservice.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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

    public boolean exists(Author author) {
        Example<Author> authorExample = createAuthorExample(author);
        return authorRepository.exists(authorExample);
    }

    public boolean existsById(Long authorId) {
        return authorRepository.existsById(authorId);
    }

    private Example<Author> createAuthorExample(Author author) {
        ExampleMatcher authorMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withMatcher("firstName",
                        ExampleMatcher.GenericPropertyMatcher::ignoreCase)
                .withMatcher("lastName",
                        ExampleMatcher.GenericPropertyMatcher::ignoreCase);

        Author authorProbe = new Author();
        authorProbe.setFirstName(author.getFirstName());
        authorProbe.setLastName(author.getLastName());
        authorProbe.setBirthDate(author.getBirthDate());
        authorProbe.setSongs(author.getSongs());

        return Example.of(authorProbe, authorMatcher);
    }
}
