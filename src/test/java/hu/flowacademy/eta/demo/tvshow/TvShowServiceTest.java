package hu.flowacademy.eta.demo.tvshow;

import hu.flowacademy.eta.demo.exceptions.ValidationException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.UUID;


public class TvShowServiceTest {

    @InjectMocks
    TvShowService tvShowService;

    @Mock
    TvShowInMemoryRepository tvShowInMemoryRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findAll() {
        when(tvShowInMemoryRepository.findAll()).thenReturn(List.of(new TvShow()));
        List<TvShow> shows = tvShowService.findAll();
        assertEquals(1, shows.size());
    }

    @Test
    public void create() {
        TvShow tvShow = getTvShow();

        when(tvShowInMemoryRepository.save(tvShow)).thenReturn(getTvShow().id(UUID.randomUUID()));

        TvShow saved = tvShowService.create(tvShow);
        assertNotNull(saved);
        assertNotNull(saved.getId());
        assertEquals(tvShow.getShowrunnerName(), saved.getShowrunnerName());
        assertEquals(tvShow.getTitle(), saved.getTitle());
    }

    @Test(expected = ValidationException.class)
    public void createNegative() {
        tvShowService.create(new TvShow().id(UUID.randomUUID()));
    }

    @Test(expected = ValidationException.class)
    public void createNegativeWithoutTitle() {
        tvShowService.create(new TvShow());
    }

    @Test(expected = ValidationException.class)
    public void createNegativeWithoutShowrunner() {
        var tvShowWithoutShowrunner = new TvShow();
        tvShowWithoutShowrunner.setTitle("something");
        tvShowService.create(tvShowWithoutShowrunner);
    }

    @Test
    public void delete() {
        tvShowService.delete(UUID.randomUUID().toString());
    }

    @Test
    public void update() {
        UUID id = UUID.randomUUID();
        var tvshow = getTvShow().id(id);
        when(tvShowInMemoryRepository.update(tvshow)).thenReturn(tvshow);
        TvShow updated = tvShowService.update(tvshow);
        assertNotNull(updated);
        assertNotNull(updated.getId());
        assertNotNull(updated.getTitle());
        assertNotNull(updated.getShowrunnerName());
    }

    @Test
    public void updateNegative() {
        tvShowService.update(getTvShow().id(null));
        // TODO...
    }

    private TvShow getTvShow() {
        TvShow tvShow = new TvShow();
        tvShow.setTitle("The lost");
        tvShow.setShowrunnerName("J. J. Abrams");
        return tvShow;
    }

}