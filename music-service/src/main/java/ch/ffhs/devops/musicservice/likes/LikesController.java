package ch.ffhs.devops.musicservice.likes;

import ch.ffhs.devops.musicservice.songs.Song;
import ch.ffhs.devops.musicservice.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@CrossOrigin
public class LikesController {

    private LikesService likesService;

    @Autowired
    public LikesController(LikesService likesService) {
        this.likesService = likesService;
    }

    @RequestMapping(value = "/users/{userId}/likes", method = GET)
    public List<Song> userLikes(@PathVariable UUID userId) {
        return likesService.songsThatUserLikes(userId);
    }

    @RequestMapping(value = "/songs/{songId}/likedBy", method = GET)
    public List<User> songsLikedByUser(@PathVariable UUID songId) {
        return likesService.usersWhoLikeSong(songId);
    }

    @RequestMapping(value = "/users/{userId}/likes", method = POST)
    public void like(@PathVariable UUID userId, @RequestBody Song song) {
        likesService.like(userId, song.getId());
    }

    @RequestMapping(value = "/songs/{songId}/likedBy", method = POST)
    public void likedBy(@PathVariable UUID songId, @RequestBody User user) {
        likesService.like(user.getId(), songId);
    }

    @RequestMapping(value = "/users/{userId}/likes/{songId}", method = DELETE)
    public void unlike(@PathVariable UUID userId, @PathVariable UUID songId) {
        likesService.unlike(userId, songId);
    }

    @RequestMapping(value = "/songs/{songId}/likedBy/{userId}", method = DELETE)
    public void unlikedBy(@PathVariable UUID songId, @PathVariable UUID userId) {
        likesService.unlike(userId, songId);
    }
}
