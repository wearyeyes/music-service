package com.ouch.musicservice.service;

import com.ouch.musicservice.model.Song;
import com.ouch.musicservice.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        return songRepository.findByAlbumIdAndId(albumId, songId);
    }

    public void addNewSongInAlbum(Long albumId, Song newSong) {
        newSong.setAlbum(albumService.getAlbumById(albumId));
        songRepository.save(newSong);
    }

    @Transactional
    public void updateSongInfoById(Long albumId, Long songId, Song updatedSong) {
        Song song = getSongById(albumId, songId);
        song.setName(updatedSong.getName());
        song.setDuration(updatedSong.getDuration());
        song.setAuthors(updatedSong.getAuthors());
        song.setAlbum(updatedSong.getAlbum());
    }

    public void deleteSongById(Long albumId, Long songId) {
        songRepository.delete(getSongById(albumId, songId));
    }

    public boolean exists(Song song) {
        Example<Song> songExample = createSongExample(song);
        return songRepository.exists(songExample);
    }

    public boolean existsById(Long songId) {
        return songRepository.existsById(songId);
    }

    private Example<Song> createSongExample(Song song) {
        ExampleMatcher songMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withMatcher("name",
                        ExampleMatcher.GenericPropertyMatcher::ignoreCase);

        Song songProbe = new Song();
        songProbe.setName(song.getName());
        songProbe.setDuration(song.getDuration());
        songProbe.setAuthors(song.getAuthors());
        songProbe.setAlbum(song.getAlbum());

        return Example.of(songProbe, songMatcher);
    }
}
