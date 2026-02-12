package main.java.com.grievance.preprocessing;

import java.util.ArrayList;
import java.util.List;

public class TextPreprocessor {

    // ==========================
    // Part by Sneha: Cleaning text
    // ==========================
    public static String cleanText(String text) {
        if (text == null) return "";

        text = text.toLowerCase();
        text = text.replaceAll("[^a-z0-9 ]", " ");
        text = text.replaceAll("\\s+", " ").trim();

        return text;
    }

    // ==========================
    // Part by Pooja: Tokenization
    // ==========================
    public static List<String> tokenize(String text) {
        text = cleanText(text);
        String[] words = text.split("\\s+");

        List<String> tokens = new ArrayList<>();
        for (String word : words) {
            if (!word.isEmpty()) tokens.add(word);
        }
        return tokens;
    }

    // ==========================
    // Part by Pooja: Simple Stemming
    // ==========================
    public static List<String> stem(List<String> tokens) {
        List<String> stems = new ArrayList<>();

        for (String word : tokens) {
            if (word.endsWith("ing")) {
                word = word.substring(0, word.length() - 3);
            } else if (word.endsWith("ed")) {
                word = word.substring(0, word.length() - 2);
            } else if (word.endsWith("s")) {
                word = word.substring(0, word.length() - 1);
            }
            stems.add(word);
        }
        return stems;
    }
}
