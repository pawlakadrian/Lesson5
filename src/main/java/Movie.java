import java.util.List;

public class Movie {
    private String title;
    private int date;
    private Director director;
    private String genre;
    private List<Actor> actors;

    public String getTitle() {
        return title;
    }

    public int getDate() {
        return date;
    }

    public Director getDirector() {
        return director;
    }

    public String getGenre() {
        return "genre: " + genre;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public String getAllInformation() {
        return "title: " + getTitle() + System.lineSeparator()
                + getDirector() + System.lineSeparator()
                + getGenre() + System.lineSeparator()
                + "date: " + getDate() + System.lineSeparator()
                + "actors: " + getActors().toString().replace("[","").replace("]","") + System.lineSeparator();
    }
}
