package com.ouch.musicservice.service;

import com.ouch.musicservice.model.Song;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    public List<Song> getAllSongs() {
        return null;
    }

    public List<Song> getAllSongsFromAlbum(Long albumId) {
        return null;
    }

    public Song getSongById(Long albumId, Long songId) { return null; }

    public void addNewSongInAlbum(Long albumId, Song newSong) {}

    public void updateSongInfoById(Long albumId, Long songId, Song updatedSong) {}

    public void deleteSongById(Long albumId, Long songId) {}
}
