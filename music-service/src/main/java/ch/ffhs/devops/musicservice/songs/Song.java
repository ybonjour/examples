package ch.ffhs.devops.musicservice.songs;

import ch.ffhs.devops.musicservice.general.Model;

import java.util.Objects;
import java.util.UUID;

public class Song implements Model {
    private UUID id;
    private String title;
    private String artist;

    public Song() {
    }

    public Song(UUID id, String title, String artist) {
        this.id = id;
        this.title = title;
        this.artist = artist;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return Objects.equals(id, song.id) &&
                Objects.equals(title, song.title) &&
                Objects.equals(artist, song.artist);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, title, artist);
    }
}
