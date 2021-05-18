package com.ouch.musicservice.web;

import com.ouch.musicservice.model.Album;
import com.ouch.musicservice.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @GetMapping
    public ResponseEntity<List<Album>> getAllAlbums() {
        List<Album> albums = albumService.getAllAlbums();
        return new ResponseEntity<>(albums, HttpStatus.OK);
    }

    @GetMapping("/{albumId}")
    public ResponseEntity<Album> getAlbumById(@PathVariable Long albumId) {
        Album album = albumService.getAlbumById(albumId);
        if (album != null) {
            return new ResponseEntity<Album>(album, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Void> createNewAlbum(@RequestBody Album newAlbum) {
        if (!albumService.exists(newAlbum)) {
            albumService.createNewAlbum(newAlbum);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/{albumId}")
    public ResponseEntity<Void> updateAlbumById(@PathVariable Long albumId,
                                @RequestBody Album updatedAlbum) {
        if (albumService.existsById(albumId)) {
            albumService.updateAlbumById(albumId, updatedAlbum);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{albumId}")
    public ResponseEntity<Void> deleteAlbumById(@PathVariable Long albumId) {
        if (albumService.existsById(albumId)) {
            albumService.deleteAlbumById(albumId);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
