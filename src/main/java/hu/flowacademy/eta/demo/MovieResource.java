package hu.flowacademy.eta.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MovieResource {

    private Map<UUID, Movie> movies = new HashMap<>();

    /**
     *
     * @return
     */
    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return new ArrayList<>(movies.values());
    }

    @GetMapping("/movie/{movie_id}")
    public Movie getMovie(@PathVariable("movie_id") String id) {
        return movies.get(UUID.fromString(id));
    }

    @PostMapping("/movie/")
    public Movie create(@RequestBody Movie movie) {
        if (movie.getId() == null) {
            UUID id = UUID.randomUUID();
            movies.put(id, movie.id(id));
            return movie;
        }
        return update(movie);
    }

    @PutMapping("/movie/")
    public Movie update(@RequestBody Movie movie) {
        if (movie.getId() != null) {
            movies.put(movie.getId(), movie);
            return movie;
        }
        return null;
    }

    @DeleteMapping("/movie/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (movies.remove(UUID.fromString(id)) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok().build();
    }

}
