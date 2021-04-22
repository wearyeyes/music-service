package com.ouch.musicservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class Author {
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private List<Album> albums;
}
