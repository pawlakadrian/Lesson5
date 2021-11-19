import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//-------------------------
        FileHandling fileHandling = new FileHandling();
        System.out.println(fileHandling.fileHandling());
//-------------------------

//-------------------------
        int chosenMenu;
        do {
            Menu.displayMenu();
            chosenMenu = Integer.parseInt(reader.readLine());
            switch (chosenMenu) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
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
}
