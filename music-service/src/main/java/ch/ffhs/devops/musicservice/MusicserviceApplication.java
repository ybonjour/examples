package ch.ffhs.devops.musicservice;

import ch.ffhs.devops.musicservice.likes.LikeExamples;
import ch.ffhs.devops.musicservice.songs.SongExamples;
import ch.ffhs.devops.musicservice.users.UserExamples;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MusicserviceApplication implements ApplicationRunner {

    private final SongExamples songExamples;
    private final UserExamples userExamples;
    private final LikeExamples likeExamples;

    @Autowired
    public MusicserviceApplication(SongExamples songExamples, UserExamples userExamples, LikeExamples likeExamples) {
        this.songExamples = songExamples;
        this.userExamples = userExamples;
        this.likeExamples = likeExamples;
    }

    public static void main(String[] args) {
        SpringApplication.run(MusicserviceApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        songExamples.fill();
        userExamples.fill();
        likeExamples.fill();
    }
}
