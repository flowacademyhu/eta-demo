package hu.flowacademy.eta.demo.tvshow;

import hu.flowacademy.eta.demo.exceptions.ValidationException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
public class TvShowService {

    private final TvShowInMemoryRepository tvShowInMemoryRepository;
    private final TvShowJPARepository tvShowJPARepository;

    public TvShowService(TvShowInMemoryRepository tvShowInMemoryRepository, TvShowJPARepository tvShowJPARepository) {
        this.tvShowInMemoryRepository = tvShowInMemoryRepository;
        this.tvShowJPARepository = tvShowJPARepository;
    }

    public List<TvShow> findAll() {
        return tvShowJPARepository.findAll();
    }

    public TvShow create(TvShow tvShow) {
        if (tvShow.getId() != null) {
            throw new ValidationException("expected id value is null, instead of " + tvShow.getId());
        }
        validateTvShow(tvShow);

        return tvShowJPARepository.save(tvShow);
    }

    public TvShow update(TvShow tvShow) {
        if (tvShow.getId() == null) {
            return create(tvShow);
        }
        validateTvShow(tvShow);

        return tvShowJPARepository.save(tvShow);
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
        tvShowJPARepository.deleteById(UUID.fromString(id));
    }
}
