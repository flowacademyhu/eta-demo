package hu.flowacademy.eta.demo.tvshow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * TvShowJPARepository extends the JpaRepository<{entity class},{type of the entity class's id}>
 * <br>
 * &#64;Repository - Special component for data storage
 */
@Repository
public interface TvShowJPARepository extends JpaRepository<TvShow, UUID> {

    /**
     * <b>findByTitle</b> represents a SQL query something like<br><pre>SELECT * FROM tv_show WHERE title=?1</pre>
     * <br>
     *
     * @param title input value of the where condition
     * @return List&#60;TvShow&#62; a result of the query
     */
    List<TvShow> findByTitle(String title);

    /**
     * <b>findCustomQuery</b> represents a custom HQL query which is the default param of the &#64;Query annotation
     * <br>
     *
     * @param s input value of the where condition, number of the seasons
     * @return List&#60;TvShow&#62; a result of the query
     */
    @Query("from TvShow t where t.length > 20 AND t.length < 190 AND t.seasons = :seasonNum")
    List<TvShow> findCustomQuery(@Param("seasonNum") int s);

}
