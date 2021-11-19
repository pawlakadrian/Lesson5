//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.io.File;
//import java.io.IOException;
//
//public class FileHandling {
//    public static MovieLibrary fileHandling() throws IOException {
//        File file = new File("src/main/java/resources/movies.json");
//
//        ObjectMapper mapper = new ObjectMapper();
//        MovieLibrary moviesLibrary = mapper.readValue(file, MovieLibrary.class);
//
//        return moviesLibrary;
//    }
//}
