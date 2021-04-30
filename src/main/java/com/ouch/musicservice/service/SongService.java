package com.ouch.musicservice.service;

import com.ouch.musicservice.model.Song;
import com.ouch.musicservice.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;
    @Autowired
    private AlbumService albumService;

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public List<Song> getAllSongsFromAlbum(Long albumId) {
        return albumService.getAlbumById(albumId).getSongs();
    }

    public Song getSongById(Long albumId, Long songId) {
        return null;
    }

    public void addNewSongInAlbum(Long albumId, Song newSong) {

    }

    public void updateSongInfoById(Long albumId, Long songId, Song updatedSong) {}

    public void deleteSongById(Long albumId, Long songId) {}
}
