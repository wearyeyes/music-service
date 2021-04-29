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
    public List<Song> getAllSongsFromAlbum(@PathVariable Long albumId) {
        return songService.getAllSongsFromAlbum(albumId);
    }

    @GetMapping("/{albumId}/songs/{songId}")
    public Song getSongById(@PathVariable Long albumId,
                            @PathVariable Long songId) {
        return songService.getSongById(albumId, songId);
    }

    @PostMapping("{albumId}/songs")
    public void addNewSongInAlbum(@PathVariable Long albumId,
                                  @RequestBody Song newSong) {
        songService.addNewSongInAlbum(albumId, newSong);
    }

    @PutMapping("/{albumId}/songs/{songId}")
    public void updateSongInfoById(@PathVariable Long albumId,
                                   @PathVariable Long songId,
                                   @RequestBody Song updatedSong) {
        songService.updateSongInfoById(albumId, songId, updatedSong);
    }

    @DeleteMapping("/{albumId}/songs/{songId}")
    public void deleteSongById(@PathVariable Long albumId,
                               @PathVariable Long songId) {
        songService.deleteSongById(albumId, songId);
    }
}
