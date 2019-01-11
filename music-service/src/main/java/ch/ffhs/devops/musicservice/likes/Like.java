package ch.ffhs.devops.musicservice.likes;

import ch.ffhs.devops.musicservice.general.Model;

import java.util.Objects;
import java.util.UUID;

public class Like implements Model {

    private UUID id;
    private UUID userId;
    private UUID songId;

    public Like(UUID id, UUID userId, UUID songId) {
        this.id = id;
        this.songId = songId;
        this.userId = userId;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getSongId() {
        return songId;
    }

    public void setSongId(UUID songId) {
        this.songId = songId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Like like = (Like) o;
        return Objects.equals(id, like.id) &&
                Objects.equals(userId, like.userId) &&
                Objects.equals(songId, like.songId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, songId);
    }
}
