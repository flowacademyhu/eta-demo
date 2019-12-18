package hu.flowacademy.eta.demo.tvshow;

import java.util.UUID;

public class TvShow {

    private UUID id;

    private String showrunnerName;

    private String title;

    private Long length;

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
