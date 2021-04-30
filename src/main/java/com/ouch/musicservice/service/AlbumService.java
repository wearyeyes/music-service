package com.ouch.musicservice.service;

import com.ouch.musicservice.model.Album;
import com.ouch.musicservice.repository.AlbumRepository;
import com.ouch.musicservice.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;
    @Autowired
    private SongService songService;

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Album getAlbumById(Long albumId) {
        return albumRepository.findById(albumId).orElseThrow();
    }

    public void createNewAlbum(Album newAlbum) {

    }

    @Transactional
    public void updateAlbumById(Long albumId,
                                Album updatedAlbum) {

    }

    public void deleteAlbumById(Long albumId) {
        albumRepository.deleteById(albumId);
    }
}
