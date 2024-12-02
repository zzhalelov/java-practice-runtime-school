package kz.practice.collections.map.task_4;

import java.util.ArrayList;
import java.util.List;

public class User {
    int id;
    String name;
    List<Integer> watchedMovies;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.watchedMovies = new ArrayList<>();
    }

    public void watchedMovies(int movieId) {
        watchedMovies.add(movieId);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", watchedMovies=" + watchedMovies +
                '}';
    }
}