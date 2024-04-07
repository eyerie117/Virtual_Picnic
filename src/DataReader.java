import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DataReader {
    public static ArrayList<String> readData() {
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("\\p{Z}+", " ");
                String[] str = line.split(" ");
                words.addAll(Arrays.asList(str));
            }

        } catch (IOException e) {
            System.out.println("Файл не найден!\n");
        }

        return words;
    }
}
