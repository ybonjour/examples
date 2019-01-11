package ch.ffhs.devops.musicservice.users;

import ch.ffhs.devops.musicservice.general.InMemoryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class Users extends InMemoryRepository<User> {
}
