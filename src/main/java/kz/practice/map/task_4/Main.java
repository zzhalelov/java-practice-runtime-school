package kz.practice.map.task_4;

import java.util.*;

public class Main {
    private static TreeMap<Integer, Movie> movieTreeMap = new TreeMap<>();
    private static TreeMap<Integer, User> userTreeMap = new TreeMap<>();

    public static void main(String[] args) {
        //добавить фильмы в мапу
        movieTreeMap.put(1, new Movie(
                1,
                "The Shawhank Redemption",
                "Drama",
                Arrays.asList("Tim Robbins", "Morgan Freeman"),
                "Frank Darabont"));
        movieTreeMap.put(2, new Movie(
                2,
                "The Dark Knight",
                "Action",
                Arrays.asList("Christian Bale", "Heath Ledger"),
                "Christopher Nolan"));
        movieTreeMap.put(2, new Movie(
                3,
                "Inception",
                "Sci-Fi",
                Arrays.asList("Leonardo DiCaprio", "Joseph Gordon-Levitt"),
                "Christopher Nolan"));
        movieTreeMap.put(4, new Movie(
                4,
                "The Godfather",
                "Drama",
                Arrays.asList("Marlon Brando", "Al Pacino"),
                "Francis Ford Coppola"));

        //добавить пользователя
        User johnDoe = new User(1, "John Doe");
        johnDoe.watchedMovies(1);
        johnDoe.watchedMovies(2);
        userTreeMap.put(1, johnDoe);


    }

    private static List<Movie> recommendMovies(int userId, int maxRecommendations) {
        HashMap<Movie, Integer> relevancy = new HashMap<>();

        User user = userTreeMap.get(userId);

        for (Integer watchedMovieId : user.watchedMovies) {
            Movie watchedMovie = movieTreeMap.get(watchedMovieId);

            for (Movie movie : movieTreeMap.values()) {
                if (!movie.id.equals(watchedMovieId)) {
                    int score = calculateScore(watchedMovie, movie);
                    if (relevancy.containsKey(movie)) {
                        relevancy.put(movie, relevancy.get(movie) + score);
                    } else {
                        relevancy.put(movie, score);
                    }
                }
            }
        }
        return new ArrayList<>();
    }

    private static int calculateScore(Movie watchedMovie, Movie movie) {
        int score = 0;

        if (watchedMovie.genre.equals(movie.genre)) {
            score++;
        }
        if (watchedMovie.director.equals(movie.director)) {
            score++;
        }
        for (String actor : watchedMovie.actors) {
            if (movie.actors.contains(actor)) {
                score++;
            }
        }
        return score;
    }
}