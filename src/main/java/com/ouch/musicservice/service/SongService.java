package com.ouch.musicservice.service;

import com.ouch.musicservice.model.Song;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SongService {
    public List<Song> getAllSongs() {
        return null;
    }

    public List<Song> getAllSongsFromAlbum() {
        return null;
    }

    public Song getSongById(Long albumId, Long songId) {
        return null;
    }

    public void addNewSongInAlbum(Long albumId) {
    }

    public void updateSongInfoById(Long albumId, Long songId) {
    }

    public void deleteSongById(Long albumId, Long songId) {
    }
}
