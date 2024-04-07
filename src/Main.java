import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            System.out.println("""
                    Выберете действие:
                    1. Посчитать количество слов
                    2. Найти самое длинное слово
                    3. Вычислить частоту слов
                    4. Завершить работу приложения
                    """);
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextLine()) {
                case "1":
                    int wordsCount = DataReview.countWords(DataReader.readData());
                    System.out.println("В этом файле " + wordsCount + " слов(-а)\n");
                    break;
                case "2":
                    String longestWord = DataReview.findLongestWorld(DataReader.readData());
                    System.out.println("Самое длинное слово(слова) в этом файле - " + longestWord + "\n");
                    break;
                case "3":
                    HashMap<String, Integer> frequency = DataReview.countWordFrequency(DataReader.readData());
                    HashMap<String, Integer> sorted = new LinkedHashMap<>();
                    Stream<Map.Entry<String, Integer>> stream = frequency.entrySet().stream();
                    stream.sorted(HashMap.Entry.<String, Integer>comparingByValue().reversed()).forEach(e -> sorted.put(e.getKey(),e.getValue()));
                    System.out.println("Количество различных слов в этом файле:\n");

                    for (Map.Entry entry : sorted.entrySet()) {
                        System.out.println(entry.getKey() + ": " + entry.getValue());
                    }
                    System.out.println();

                    break;
                case "4":
                    System.out.println("Приложение завершило работу");
                    flag = false;
                    break;
                default:
                    System.out.println("Такого пункта меню не существует, выберете из предложенных\n");
                    break;
            }
        }
    }
}
