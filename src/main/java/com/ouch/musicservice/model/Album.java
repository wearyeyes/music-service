package com.ouch.musicservice.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "album_sequence")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Album {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "album_sequence"
    )
    private Long id;

    private String name;

    private Duration duration;

    @JsonManagedReference
    @OneToMany(
            mappedBy = "album",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Song> songs;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate createdDate;
}
