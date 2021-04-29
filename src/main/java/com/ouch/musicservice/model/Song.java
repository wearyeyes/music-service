package com.ouch.musicservice.model;

import lombok.*;

import javax.persistence.*;
import java.time.Duration;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Song {
    @Id
    @SequenceGenerator(
            name = "song_sequence",
            sequenceName = "song_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "song_sequence"
    )
    private Long id;

    private String name;

    private Duration duration;

    @ManyToMany
    @JoinTable(
            name = "m2m_author_song",
            joinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "song_id", referencedColumnName = "id")
    )
    private List<Author> authors;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;
}