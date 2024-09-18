package kz.practice.exception.task_3;

public class Main {
    public static void main(String[] args) {
        try {
            for (Event event : getMovies()) {
                validEvent(event);
            }
            for (Event event : getTheatres()) {
                validEvent(event);
            }
            System.out.println("Все события корректны");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Movie[] getMovies() {
        return new Movie[]{
                new Movie("Inception", 2010, 16),
                new Movie("Titanic", 1997, 18),
                new Movie("Avatar", 2009, 14)
        };
    }

    public static Theatre[] getTheatres() {
        return new Theatre[]{
                new Theatre("Анна Каренина", 2017, 16),
                new Theatre("Гамлет", 2005, 16),
                new Theatre("Евгений Онегин", 1997, 18)
        };
    }

    public static void validEvent(Event event) {
        if (event.getTitle() == null || event.getReleaseYear() == 0 || event.getAge() == 0) {
            throw new RuntimeException("Некорректное мероприятие: " + event);
        }
    }
}