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
    public Album getAlbumById(@PathVariable Long albumId) {
        return albumService.getAlbumById(albumId);
    }

    @PostMapping
    public void createNewAlbum(@RequestBody Album newAlbum) {
        albumService.createNewAlbum(newAlbum);
    }

    @PutMapping("/{albumId}")
    public void updateAlbumById(@PathVariable Long albumId,
                                @RequestBody Album updatedAlbum) {
        albumService.updateAlbumById(albumId, updatedAlbum);
    }

    @DeleteMapping("/{albumId}")
    public void deleteAlbumById(@PathVariable Long albumId) {
        albumService.deleteAlbumById(albumId);
    }
}
