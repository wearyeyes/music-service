package com.ouch.musicservice.service;

import com.ouch.musicservice.model.Album;
import com.ouch.musicservice.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Album getAlbumById(Long albumId) {
        return albumRepository.findById(albumId).orElseThrow();
    }

    public void createNewAlbum(Album newAlbum) {
        albumRepository.save(newAlbum);
    }

    @Transactional
    public void updateAlbumById(Long albumId,
                                Album updatedAlbum) {
        Album albumFromDB = albumRepository.findById(albumId).orElseThrow();
        albumFromDB.setName(updatedAlbum.getName());
        albumFromDB.setDuration(updatedAlbum.getDuration());
        albumFromDB.setCreatedDate(updatedAlbum.getCreatedDate());

        albumFromDB.setSongs(updatedAlbum.getSongs());
    }

    public void deleteAlbumById(Long albumId) {
        albumRepository.deleteById(albumId);
    }
}
