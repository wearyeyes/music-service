package com.ouch.musicservice.web;

import com.ouch.musicservice.model.Author;
import com.ouch.musicservice.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> authors = authorService.getAllAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @GetMapping("/{authorId}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long authorId) {
        Author author = authorService.getAuthorById(authorId);
        if (author != null) {
            return new ResponseEntity<>(author, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Void> createNewAuthor(@RequestBody Author newAuthor) {
        if (!authorService.exists(newAuthor)) {
            authorService.createNewAuthor(newAuthor);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{authorId}")
    public ResponseEntity<Void> updateAuthorById(@PathVariable Long authorId,
                                 @RequestBody Author updatedAuthor) {
        if (authorService.existsById(authorId)) {
            authorService.updateAuthorById(authorId, updatedAuthor);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{authorId}")
    public ResponseEntity<Void> deleteAuthorById(@PathVariable Long authorId) {
        if (authorService.existsById(authorId)) {
            authorService.deleteAuthorById(authorId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
