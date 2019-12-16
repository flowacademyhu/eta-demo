package hu.flowacademy.eta.demo.tvshow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
public class TvShowService {

    @Autowired
    private TvShowRepository tvShowRepository;

    public List<TvShow> findAll() {
        return tvShowRepository.findAll();
    }

    public TvShow create(TvShow tvShow) {
        if (tvShow.getId() != null) {
            throw new RuntimeException("missing id");
        }
        validateTvShow(tvShow);

        return tvShowRepository.save(tvShow);
    }

    public TvShow update(TvShow tvShow) {
        if (tvShow.getId() == null) {
            return create(tvShow);
        }
        validateTvShow(tvShow);

        return tvShowRepository.update(tvShow);
    }

    private void validateTvShow(TvShow tvShow) {
        if (StringUtils.isEmpty(tvShow.getTitle())) {
            throw new RuntimeException("missing title");
        }
        if (StringUtils.isEmpty(tvShow.getShowrunnerName())) {
            throw new RuntimeException("missing showrunner's name");
        }
    }

    public void delete(String id) {
        tvShowRepository.delete(UUID.fromString(id));
    }
}
