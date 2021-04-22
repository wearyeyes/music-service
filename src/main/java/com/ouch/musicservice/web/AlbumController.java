package com.ouch.musicservice.web;

import com.ouch.musicservice.model.Album;
import com.ouch.musicservice.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @GetMapping
    public List<Album> getAllAlbums() {
        return albumService.getAllAlbums();
    }

    @GetMapping("/{albumId}")
    public Album getAlbumById(Long albumId) {
        return albumService.getAlbumById(albumId);
    }

    @PostMapping
    public void createNewAlbum() {
        albumService.createNewAlbum();
    }

    @PutMapping("/{albumId}")
    public void updateAlbumById(Long albumId) {
        albumService.updateAlbumById(albumId);
    }

    @DeleteMapping("/{albumId}")
    public void deleteAlbumById(Long albumId) {
        albumService.deleteAlbumById(albumId);
    }
}
