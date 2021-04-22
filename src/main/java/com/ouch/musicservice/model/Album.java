package com.ouch.musicservice.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
public class Album {
    private long id;
    private String name;
    private Duration duration;
    private List<Song> songs;
    private LocalDate createdDate;
}
