package com.ouch.musicservice.dto;

import com.ouch.musicservice.model.Album;
import com.ouch.musicservice.model.Author;
import lombok.Data;

import java.util.List;

@Data
public class SongDto {
    private String name;
    private String duration;
    private List<Author> authors;
    private Album album;
}
