package hu.flowacademy.eta.demo.tvshow;

import hu.flowacademy.eta.demo.exceptions.ValidationException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
public class TvShowService {

    private final TvShowRepository tvShowRepository;

    public TvShowService(TvShowRepository tvShowRepository) {
        this.tvShowRepository = tvShowRepository;
    }

    public List<TvShow> findAll() {
        return tvShowRepository.findAll();
    }

    public TvShow create(TvShow tvShow) {
        if (tvShow.getId() != null) {
            throw new ValidationException("expected id value is null, instead of " + tvShow.getId());
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
            throw new ValidationException("missing title");
        }
        if (StringUtils.isEmpty(tvShow.getShowrunnerName())) {
            throw new ValidationException("missing showrunner's name");
        }
    }

    public void delete(String id) {
        tvShowRepository.delete(UUID.fromString(id));
    }
}
