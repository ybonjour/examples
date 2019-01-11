package ch.ffhs.devops.musicservice.likes;

import ch.ffhs.devops.musicservice.general.InMemoryRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class Likes extends InMemoryRepository<Like> {
    public List<Like> byUserId(UUID userId) {
        return models
                .stream()
                .filter(like -> like.getUserId().equals(userId))
                .collect(Collectors.toList());

    }

    public List<Like> bySongId(UUID songId) {
        return models
                .stream()
                .filter(like -> like.getSongId().equals(songId))
                .collect(Collectors.toList());
    }

    public Optional<Like> byUserIdAndSongId(UUID userId, UUID songId) {
        return models
                .stream()
                .filter(like -> like.getUserId().equals(userId) && like.getSongId().equals(songId))
                .findFirst();
    }
}
