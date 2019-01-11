package ch.ffhs.devops.musicservice.likes;

import ch.ffhs.devops.musicservice.songs.Song;
import ch.ffhs.devops.musicservice.songs.Songs;
import ch.ffhs.devops.musicservice.users.User;
import ch.ffhs.devops.musicservice.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class LikeExamples {
    private Likes likes;
    private Songs songs;
    private Users users;

    @Autowired
    public LikeExamples(Likes likes, Songs songs, Users users) {
        this.likes = likes;
        this.songs = songs;
        this.users = users;
    }

    public void fill() {
        Song song = songs.all().get(0);
        User user = users.all().get(0);

        Like like = new Like(UUID.randomUUID(), user.getId(), song.getId());
        likes.add(like);
    }
}
