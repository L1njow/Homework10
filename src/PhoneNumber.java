import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhoneNumber {
    public static void main(String[] args) {

        try (Scanner s = new Scanner(new File("file.txt"));) {
            while(s.hasNextLine()) {
                String number = s.nextLine();
                if (number.matches("[0-9]{3}-[0-9]{3}-[0-9]{4}|\\([0-9]{3}\\)\\s[0-9]{3}-[0-9]{4}")) {
                    System.out.println(number);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }

    }
}
