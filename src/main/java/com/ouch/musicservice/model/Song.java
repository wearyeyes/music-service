package com.ouch.musicservice.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.time.Duration;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "song_sequence")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Song {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "song_sequence"
    )
    private Long id;

    private String name;

    private Duration duration;

    @ManyToMany(mappedBy = "songs")
    private List<Author> authors;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;
}