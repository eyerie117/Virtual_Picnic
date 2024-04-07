import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class DataReview {
    public static int countWords(ArrayList<String> words) {
        return words.size();
    }

    public static String findLongestWorld(ArrayList<String> words) {
        String s = "";
        for (String word: words) {
            if (word.length() > s.length()) {
                s = word;
            }
        }
        HashSet<String> longestWorlds = new HashSet<>();
        longestWorlds.add(s);
        for (String word: words) {
            if (word.length() == s.length() && !word.equals(s)) {
                longestWorlds.add(word);
            }
        }

        StringBuilder findResult = new StringBuilder();
        for (String i: longestWorlds) {
            findResult.append(i).append(" ");
        }

        return findResult.toString().trim().replace(" ", ", ");
    }

    public static HashMap<String, Integer>  countWordFrequency(ArrayList<String> words) {
        ArrayList<String> lowCase = new ArrayList<>();

        for (String word: words) {
            lowCase.add(word.toLowerCase());
        }

        HashMap<String, Integer> wordFrequency = new HashMap<>();

        for (String s: lowCase) {
            boolean repeat = false;
            for (String key : wordFrequency.keySet()) {
                Integer count = wordFrequency.get(key);
                if (s.equals(key)) {
                    wordFrequency.put(s, count + 1);
                    repeat = true;
                }
            }
            if (!repeat) wordFrequency.put(s, 1);
        }

        return wordFrequency;
    }
}
