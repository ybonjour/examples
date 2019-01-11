package ch.ffhs.devops.musicservice.songs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class SongExamples {
    private final Songs songs;

    @Autowired
    public SongExamples(Songs songs) {
        this.songs = songs;
    }

    public void fill() {
        Song song = new Song(UUID.fromString("048c94ce-2e17-4d0e-98e4-a989efea1fb3"), "Let it be", "The Beatles");
        songs.add(song);
    }
}
