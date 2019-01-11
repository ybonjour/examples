package ch.ffhs.devops.musicservice.songs;

import ch.ffhs.devops.musicservice.NotFoundException;
import ch.ffhs.devops.musicservice.likes.Like;
import ch.ffhs.devops.musicservice.likes.Likes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@CrossOrigin
public class SongController {
    private final Songs songs;
    private final Likes likes;

    @Autowired
    public SongController(Songs songs, Likes likes) {
        this.songs = songs;
        this.likes = likes;
    }

    @RequestMapping(value = "/songs", method = GET)
    public List<Song> songs() {
        return songs.all();
    }

    @RequestMapping(value = "/songs/{songId}", method = GET)
    public Song songById(@PathVariable UUID songId) {
        return songs.byId(songId)
                .orElseThrow(NotFoundException::new);
    }

    @RequestMapping(value = "/songs/{songId}", method = PATCH)
    public void replaceSong(@PathVariable UUID songId, @RequestBody Song newSong) {
        songs.replace(songId, newSong);
    }

    @RequestMapping(value = "/songs", method = POST)
    public void addSong(@RequestBody Song song) {
        songs.add(song);
    }

    @RequestMapping(value = "/songs/{songId}", method = DELETE)
    public void deleteSong(@PathVariable UUID songId) {
        for (Like like : likes.bySongId(songId)) {
            likes.remove(like.getId());
        }
        songs.remove(songId);
    }
}
