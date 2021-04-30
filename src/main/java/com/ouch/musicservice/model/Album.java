package com.ouch.musicservice.model;

import lombok.*;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Album {
    @Id
    @SequenceGenerator(
            name = "album_sequence",
            sequenceName = "album_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "album_sequence"
    )
    private Long id;

    private String name;

    private Duration duration;

    @OneToMany(mappedBy = "album")
    private List<Song> songs;

    private LocalDate createdDate;
}
