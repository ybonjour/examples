package ch.ffhs.devops.musicservice.general;

import ch.ffhs.devops.musicservice.songs.Song;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class InMemoryRepositoryTest {

    private static Song LET_IT_BE = new Song(UUID.randomUUID(), "Let it be", "Beatles");
    private static Song CALIFORNIACATION = new Song(UUID.randomUUID(), "Californiacation", "Red Hot Chilli Peppers");

    private InMemoryRepository<Song> repository;

    @Before
    public void setUp() {
        repository = new InMemoryRepository<Song>() {
        };
    }

    @Test
    public void storesElementsById() {
        repository.add(LET_IT_BE);

        Optional<Song> result = repository.byId(LET_IT_BE.getId());

        assertThat(result.orElse(null), is(LET_IT_BE));
    }

    @Test
    public void storesMultipleElements() {
        repository.add(CALIFORNIACATION);
        repository.add(LET_IT_BE);

        List<Song> result = repository.all();

        assertThat(result.size(), is(2));
        assertThat(result, Matchers.hasItem(CALIFORNIACATION));
        assertThat(result, Matchers.hasItem(LET_IT_BE));
    }

    @Test
    public void canRemoveElement() {
        repository.add(LET_IT_BE);

        repository.remove(LET_IT_BE.getId());

        assertThat(repository.all(), is(emptyList()));
    }

    @Test
    public void replacesElement() {
        repository.add(LET_IT_BE);

        repository.replace(LET_IT_BE.getId(), CALIFORNIACATION);

        assertThat(repository.all(), is(singletonList(CALIFORNIACATION)));
    }

    @Test
    public void doesNotReplaceNonExistingElement() {
        repository.replace(LET_IT_BE.getId(), CALIFORNIACATION);

        assertThat(repository.all(), is(emptyList()));
    }
}