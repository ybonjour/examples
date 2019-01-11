package ch.ffhs.devops.musicservice.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserExamples {
    private final Users users;

    @Autowired
    public UserExamples(Users users) {
        this.users = users;
    }

    public void fill() {
        User user = new User(UUID.fromString("048c94ce-2e17-4d0e-98e4-a989efea1fb3"), "Yves");
        users.add(user);
    }
}
