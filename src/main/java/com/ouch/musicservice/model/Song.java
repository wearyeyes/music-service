package com.ouch.musicservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.util.List;

@Data
@NoArgsConstructor
public class Song {
    private long id;
    private String name;
    private Duration duration;
    private List<Author> authors;
    private Album album;
}
