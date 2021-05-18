package com.ouch.musicservice.service;

import com.ouch.musicservice.model.Album;
import com.ouch.musicservice.model.Author;
import com.ouch.musicservice.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
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

    public boolean exists(Album album) {
        Example<Album> albumExample = createAlbumExample(album);
        return albumRepository.exists(albumExample);
    }

    public boolean existsById(Long albumId) {
        return albumRepository.existsById(albumId);
    }

    private Example<Album> createAlbumExample(Album album) {
        ExampleMatcher albumMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id", "songs", "duration", "createdDate")
                .withMatcher("name",
                        ExampleMatcher.GenericPropertyMatcher::ignoreCase);

        Album albumProbe = new Album();
        albumProbe.setName(album.getName());

        return Example.of(albumProbe, albumMatcher);
    }
}
