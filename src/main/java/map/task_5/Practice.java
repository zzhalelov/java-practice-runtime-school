package map.task_5;

import java.util.HashMap;
import java.util.Map;

public class Practice {
    public static void main(String[] args) {
        Map<String, Map<String, Double>> films = new HashMap<>();

        Map<String, Double> value = new HashMap<>() {{
            put("IMDb", 8.6);
            put("Kinopoisk", 8.7);
        }};
        films.put("Interstellar", value);

        value = new HashMap<>() {{
            put("IMDb", 8.8);
            put("Kinopoisk", 8.6);
        }};
        films.put("Inception", value);

        value = new HashMap<>() {{
            put("IMDb", 8.3);
            put("Kinopoisk", 8.2);
        }};
        films.put("Star Wars IV: Return of the Jedi", value);

        //вывод на печать
        for (Map.Entry<String, Map<String, Double>> entry : films.entrySet()) {
            System.out.println("Фильм: " + entry.getKey());
            System.out.println("Оценки: ");
            for (Map.Entry<String, Double> ratingEntry : entry.getValue().entrySet()) {
                System.out.println(ratingEntry.getKey() + ": " + ratingEntry.getValue());
            }
            System.out.println();
        }

        String highestRatedIMDbMovie = null;
        String highestRatedKinopoiskMovie = null;
        double highestIMDbRating = 0.0;
        double highestKinopoiskRating = 0.0;

        for (Map.Entry<String, Map<String, Double>> entry : films.entrySet()) {
            String title = entry.getKey();
            Map<String, Double> ratings = entry.getValue();

            if (ratings.containsKey("Imdb") && ratings.get("Imdb") > highestIMDbRating) {
                highestIMDbRating = ratings.get("Imdb");
                highestRatedIMDbMovie = title;
            }

            if (ratings.containsKey("Kinopoisk") && ratings.get("Kinopoisk") > highestKinopoiskRating) {
                highestKinopoiskRating = ratings.get("Kinopoisk");
                highestRatedKinopoiskMovie = title;
            }
        }

        System.out.println("Самый высокооцененный фильм IMDb: " + highestRatedIMDbMovie + " с рейтингом " + highestIMDbRating);
        System.out.println("Самый высокооцененный фильм Kinopoisk: " + highestRatedKinopoiskMovie + " с рейтингом " + highestKinopoiskRating);
    }
}