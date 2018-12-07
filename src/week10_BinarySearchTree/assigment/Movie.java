package week10_BinarySearchTree.assigment;

import java.util.Objects;

/**
 *
 * @author Jeremy Santorelli
 */
public class Movie implements Comparable {

    private String title;
    private String director;
    private String year, genre;

    public Movie(String title, String director, String year, String genre) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "title=" + title + "\n director=" + director + "\n year=" + year + "\n genre=" + genre;
    }

    @Override
    public int compareTo(Object o) {
        final Movie other = (Movie) o;
        int ret;
        if (this.equals(other)) {
            ret = 0;
        } else {
            ret = this.hashCode() - other.hashCode();
        }
        return ret;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.title);
        hash = 79 * hash + Objects.hashCode(this.director);
        hash = 79 * hash + Objects.hashCode(this.year);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Movie other = (Movie) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.director, other.director)) {
            return false;
        }
        return Objects.equals(this.year, other.year);
    }

}
