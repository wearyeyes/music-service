package com.ouch.musicservice.model;

import lombok.*;

import javax.persistence.*;
import java.time.Duration;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
public class Song {
    @Id
    @SequenceGenerator(
            name = "song_sequence",
            sequenceName = "song_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "song_sequence"
    )
    private Long id;

    private String name;

    private Duration duration;

    @OneToMany(mappedBy = "songs")
    private List<Author> authors;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;
}