package ch.ffhs.devops.musicservice.likes;

import ch.ffhs.devops.musicservice.songs.Song;
import ch.ffhs.devops.musicservice.songs.Songs;
import ch.ffhs.devops.musicservice.users.User;
import ch.ffhs.devops.musicservice.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LikesService {
    private Likes likes;
    private Users users;
    private Songs songs;

    @Autowired
    public LikesService(Likes likes, Users users, Songs songs) {
        this.likes = likes;
        this.users = users;
        this.songs = songs;
    }

    public List<User> usersWhoLikeSong(UUID songId) {
        return likes
                .bySongId(songId).stream()
                .map(like -> users.byId(like.getUserId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public List<Song> songsThatUserLikes(UUID userId) {
        return likes.byUserId(userId).stream()
                .map(like -> songs.byId(like.getSongId()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public void like(UUID userId, UUID songId) {
        Like like = new Like(UUID.randomUUID(), userId, songId);
        likes.add(like);
    }

    public void unlike(UUID userId, UUID songId) {
        likes
                .byUserIdAndSongId(userId, songId)
                .ifPresent(like -> likes.remove(like.getId()));
    }
}
