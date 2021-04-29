package com.ouch.musicservice;

import com.ouch.musicservice.model.Album;
import com.ouch.musicservice.repository.AlbumRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(MusicServiceApplication.class, args);
	}
}
