package com.ouch.musicservice.web;

import com.ouch.musicservice.model.Author;
import com.ouch.musicservice.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{authorId}")
    public Author getAuthorById(@PathVariable Long authorId) {
        return authorService.getAuthorById(authorId);
    }

    @PostMapping
    public void createNewAuthor(@RequestBody Author newAuthor) {
        authorService.createNewAuthor(newAuthor);
    }

    @PutMapping("/{authorId}")
    public void updateAuthorById(@PathVariable Long authorId,
                                 @RequestBody Author updatedAuthor) {
        authorService.updateAuthorById(authorId, updatedAuthor);
    }

    @DeleteMapping("/{authorId}")
    public void deleteAuthorById(@PathVariable Long authorId) {
        authorService.deleteAuthorById(authorId);
    }
}
