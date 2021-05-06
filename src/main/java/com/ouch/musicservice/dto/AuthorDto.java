package com.ouch.musicservice.dto;

import com.ouch.musicservice.model.Song;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AuthorDto {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private List<Song> songs;
}
