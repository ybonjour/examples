package ch.ffhs.devops.musicservice.users;

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
public class UserController {
    private final Users users;
    private final Likes likes;

    @Autowired
    public UserController(Users users, Likes likes) {
        this.users = users;
        this.likes = likes;
    }

    @RequestMapping(value = "/users", method = GET)
    public List<User> users() {
        return users.all();
    }

    @RequestMapping(value = "/users/{userId}", method = GET)
    public User userById(@PathVariable UUID userId) {
        return users.byId(userId)
                .orElseThrow(NotFoundException::new);
    }

    @RequestMapping(value = "/users/{userId}", method = PATCH)
    public void replaceUser(@PathVariable UUID userId, @RequestBody User newUser) {
        users.replace(userId, newUser);
    }

    @RequestMapping(value = "/users", method = POST)
    public void addUser(@RequestBody User user) {
        users.add(user);
    }

    @RequestMapping(value = "/users/{userId}", method = DELETE)
    public void deleteUser(@PathVariable UUID userId) {
        for (Like like : likes.byUserId(userId)) {
            likes.remove(like.getId());
        }
        users.remove(userId);
    }
}
