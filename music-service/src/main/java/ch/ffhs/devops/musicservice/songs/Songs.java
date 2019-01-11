package ch.ffhs.devops.musicservice.songs;

import ch.ffhs.devops.musicservice.general.InMemoryRepository;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class Songs extends InMemoryRepository<Song> {
    private final Counter counter;

    @Autowired
    public Songs(MeterRegistry registry) {
        this.counter = Counter.builder("addedSongs").description("Number of added songs").register(registry);
    }

    @Override
    public void add(Song newModel) {
        counter.increment();
        super.add(newModel);
    }
}
