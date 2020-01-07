package hu.flowacademy.eta.demo.tvshow;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TvShowInMemoryRepository {

    private Map<Long, TvShow> data = new HashMap<>();

    public List<TvShow> findAll() {
        return new ArrayList<>(data.values());
    }

    public TvShow save(TvShow tvShow) {
        var id = new Random().nextLong();
        tvShow.setId(id);
        data.put(id, tvShow);
        return tvShow;
    }

    public TvShow update(TvShow tvShow) {
        data.put(tvShow.getId(), tvShow);
        return tvShow;
    }

    public void delete(Long fromString) {
        data.remove(fromString);
    }
}
