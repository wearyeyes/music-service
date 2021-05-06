package com.ouch.musicservice.dto;

import com.ouch.musicservice.model.Song;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class AlbumDto {
    private String name;
    private String duration;
    private List<Song> songs;
    private LocalDate createdDate;
}
