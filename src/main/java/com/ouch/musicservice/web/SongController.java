package com.ouch.musicservice.web;

import com.ouch.musicservice.model.Song;
import com.ouch.musicservice.service.AlbumService;
import com.ouch.musicservice.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class SongController {
    @Autowired
    private SongService songService;

    @Autowired
    private AlbumService albumService;

    @GetMapping("/songs")
    public ResponseEntity<List<Song>> getAllSongs() {
        List<Song> songs = songService.getAllSongs();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("/{albumId}/songs")
    public ResponseEntity<List<Song>> getAllSongsFromAlbum(@PathVariable Long albumId) {
        if (albumService.existsById(albumId)) {
            List<Song> songs = songService.getAllSongsFromAlbum(albumId);
            return new ResponseEntity<>(songs, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{albumId}/songs/{songId}")
    public ResponseEntity<Song> getSongById(@PathVariable Long albumId,
                            @PathVariable Long songId) {
        if (albumService.existsById(albumId)
                || songService.existsById(songId)) {
            Song song = songService.getSongById(albumId, songId);
            return new ResponseEntity<>(song, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("{albumId}/songs")
    public ResponseEntity<Void> addNewSongInAlbum(@PathVariable Long albumId,
                                  @RequestBody Song newSong) {
        if (albumService.existsById(albumId)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (!songService.exists(newSong)) {
            songService.addNewSongInAlbum(albumId, newSong);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{albumId}/songs/{songId}")
    public ResponseEntity<Void> updateSongInfoById(@PathVariable Long albumId,
                                   @PathVariable Long songId,
                                   @RequestBody Song updatedSong) {
        if (albumService.existsById(albumId)
                || songService.existsById(songId)) {
            songService.updateSongInfoById(albumId, songId, updatedSong);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{albumId}/songs/{songId}")
    public ResponseEntity<Void> deleteSongById(@PathVariable Long albumId,
                               @PathVariable Long songId) {
        if (albumService.existsById(albumId)
                || songService.existsById(songId)) {
            songService.deleteSongById(albumId, songId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
