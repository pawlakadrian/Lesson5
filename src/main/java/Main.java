import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.ElementType;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//-------------------------
        File file = new File("src/main/java/resources/movies.json");

        ObjectMapper mapper = new ObjectMapper();
        MovieLibrary moviesLibrary = mapper.readValue(file, MovieLibrary.class);

//-------------------------
        int chosenMenu;
        do {
            Menu.displayMenu();
            chosenMenu = Integer.parseInt(reader.readLine());
            switch (chosenMenu) {
                case 1:
                    getMoviesBetweenDates(reader, moviesLibrary);
                    break;
                case 2:
                    getRandomMovie(moviesLibrary);
                    break;
                case 3:
                    getMoviesWithActorPlayed(reader, moviesLibrary);
                    break;
                case 4:
                    System.out.println("Close the program");
                    break;
                default:
                    System.out.println("Please again chose one option from: 1-4");
            }
        }
        while (chosenMenu < 4);
    }

    public static void getMoviesBetweenDates(BufferedReader reader, MovieLibrary movieLibrary) throws IOException {
        System.out.println("Please enter the first date: ");
        int firstDate = Integer.parseInt(reader.readLine());
        System.out.println("Please enter the second date: ");
        int secondDate = Integer.parseInt(reader.readLine());

        searchMoviesBetweenDates(firstDate, secondDate, movieLibrary);
    }

    public static void searchMoviesBetweenDates(int firstDate, int secondDate, MovieLibrary movieLibrary) {
        if (firstDate <= secondDate) {
            movieLibrary.getMovies()
                    .stream()
                    .filter(m -> m.getDate() >= firstDate)
                    .filter(m -> m.getDate() <= secondDate)
                    .forEach(m -> System.out.println(m.getAllInformation()));
        } else {
            System.out.println("Please provide valid dates");
        }
    }

    public static void getRandomMovie(MovieLibrary movieLibrary) {
        Random randomGenerator = new Random();
        int index = randomGenerator.nextInt(movieLibrary.getMovies().size());
        System.out.println(movieLibrary.getMovies().get(index).getAllInformation());
    }

    public static void getMoviesWithActorPlayed(BufferedReader reader, MovieLibrary movieLibrary) throws IOException {
        System.out.println("Please enter actor first name and last name: ");
        String actorName = reader.readLine();
        System.out.println("Actor " + actorName + " played in following movies: ");

        for (Movie movie : movieLibrary.getMovies()) {
            movie.getActors()
                    .stream()
                    .filter(m -> m.toString().equals(actorName))
                    .forEach(m -> System.out.println(movie.getTitle()));
        }

        System.out.println();
    }
}
