package hu.flowacademy.eta.demo.tvshow;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table
public class TvShow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

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
