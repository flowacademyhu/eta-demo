package hu.flowacademy.eta.demo.tvshow;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TvShowRepository {

    private Map<UUID, TvShow> data = new HashMap<>();

    public List<TvShow> findAll() {
        return new ArrayList<>(data.values());
    }

    public TvShow save(TvShow tvShow) {
        UUID id = UUID.randomUUID();
        tvShow.setId(id);
        data.put(id, tvShow);
        return tvShow;
    }

    public TvShow update(TvShow tvShow) {
        data.put(tvShow.getId(), tvShow);
        return tvShow;
    }

    public void delete(UUID fromString) {
        data.remove(fromString);
    }
}
