package hu.flowacademy.eta.demo.tvshow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TvShowResource {

    @Autowired
    private TvShowService tvShowService;

    @GetMapping("/shows")
    public List<TvShow> getShows() {
        return tvShowService.findAll();
    }

    @PostMapping("/show")
    public TvShow createShow(@RequestBody TvShow tvShow) {
        return tvShowService.create(tvShow);
    }

    @PutMapping("/show")
    public TvShow updateShow(@RequestBody TvShow tvShow) {
        return tvShowService.update(tvShow);
    }

    @DeleteMapping("/show/{id}")
    public ResponseEntity<Void> deleteShow(@PathVariable Long id) {
        tvShowService.delete(id);
        return ResponseEntity.ok().build();
    }

}
