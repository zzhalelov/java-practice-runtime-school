package map.task_4;

import java.util.List;

public class Movie {
    Integer id;
    String title;
    String genre;
    List<String> actors;
    String director;

    public Movie(Integer id, String title, String genre, List<String> actors, String director) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.actors = actors;
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", actors=" + actors +
                ", director='" + director + '\'' +
                '}';
    }
}