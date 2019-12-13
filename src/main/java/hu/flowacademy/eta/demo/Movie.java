package hu.flowacademy.eta.demo;

import java.time.LocalDate;
import java.util.UUID;

public class Movie {

    private UUID id;

    private String title;

    private LocalDate releaseDate;

    private String directorName;

    private Style style;

    private boolean wonOscar;

    private int length;

    public Movie(String title, LocalDate releaseDate, String directorName, Style style, boolean wonOscar, int length) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.directorName = directorName;
        this.style = style;
        this.wonOscar = wonOscar;
        this.length = length;
    }

    public enum Style {
        ACTION, ROMCOM, SCI_FI, FANTASY, DOCUMENTARY, COMEDY, DRAMA, ANIMATED
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Movie id(UUID id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public boolean isWonOscar() {
        return wonOscar;
    }

    public void setWonOscar(boolean wonOscar) {
        this.wonOscar = wonOscar;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
