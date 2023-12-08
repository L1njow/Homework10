import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JsonFile {
    public static void main(String[] args) {

        List<User> list = new ArrayList<>();
        try (Scanner s = new Scanner(new File("user.txt"));) {
            s.nextLine();
            while(s.hasNext()) {
                User user = new User(s.next(), s.nextInt());
                list.add(user);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter fos = new FileWriter("user.json")) {
            String gsonString = gson.toJson(list);
            fos.write(gsonString);
        } catch (IOException e) {
            System.out.println("Error");
        }

    }
}
