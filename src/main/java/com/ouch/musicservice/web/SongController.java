package com.ouch.musicservice.web;

import com.ouch.musicservice.model.Song;
import com.ouch.musicservice.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping("/songs")
    public List<Song> getAllSongs() {
        return songService.getAllSongs();
    }

    @GetMapping("/{albumId}/songs")
    public List<Song> getAllSongsFromAlbum() {
        return songService.getAllSongsFromAlbum();
    }

    @GetMapping("/{albumId}/songs/{songId}")
    public Song getSongById(Long albumId, Long songId) {
        return songService.getSongById(albumId, songId);
    }

    @PostMapping("{albumId}/songs")
    public void addNewSongInAlbum(Long albumId) {
        songService.addNewSongInAlbum(albumId);
    }

    @PutMapping("/{albumId}/songs/{songId}")
    public void updateSongInfoById(Long albumId, Long songId) {
        songService.updateSongInfoById(albumId, songId);
    }

    @DeleteMapping("/{albumId}/songs/{songId}")
    public void deleteSongById(Long albumId, Long songId) {
        songService.deleteSongById(albumId, songId);
    }
}
