package hu.flowacademy.eta.demo.tvshow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TvShowJPARepository extends JpaRepository<TvShow, UUID> {

    List<TvShow> findByTitle(String title);

    @Query("from TvShow t where t.length > 20 AND t.length < 190 AND t.seasons = :seasonNum")
    List<TvShow> findCustomQuery(@Param("seasonNum") int s);

}
