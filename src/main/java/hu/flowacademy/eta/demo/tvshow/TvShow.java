package hu.flowacademy.eta.demo.tvshow;

import javax.persistence.*;
import java.util.UUID;

/**
 * TvShow contains a tv show's data
 * <br>
 * &#64;Entity - shows that TvShow class represents a database table, <b>required</b> in JPA definition
 * <br>
 * &#64;Table - helps us to do a more specific definition for the database table
 */
@Entity
@Table
public class TvShow {

    /**
     * The id column of the table
     * <br>
     * &#64;Id - shows that this attribute is the primary key of the table <b>required</b>
     * <br>
     * &#64;GeneratedValue - define auto increment for this column
     * <br>
     * &#64;SequenceGenerator - define sequence parameters
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tv_show_seq")
    @SequenceGenerator(name = "tv_show_seq", sequenceName = "tv_show_seq", allocationSize = 1, initialValue = 1)
    private UUID id;

    /**
     * An example for column definition
     * <br>
     * &#64;Column - define the column detailsw
     */
    @Column(length = 50)
    private String showrunnerName;

    @Column
    private String title;

    @Column
    private Long length;

    @Column
    private int seasons;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getShowrunnerName() {
        return showrunnerName;
    }

    public void setShowrunnerName(String showrunnerName) {
        this.showrunnerName = showrunnerName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public TvShow id(UUID id) {
        this.id = id;
        return this;
    }
}
