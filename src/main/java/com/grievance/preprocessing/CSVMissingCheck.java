package main.java.com.grievance.preprocessing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CSVMissingCheck {

    // ==========================
    // Part by Mydhily: Stopword list
    // ==========================
    static Set<String> stopWords = new HashSet<>(Arrays.asList(
            "is", "the", "and", "to", "of", "in", "a", "an", "for", "on", "with"
    ));

    // ==========================
    // Part by Mydhily: Check missing / empty values + stopword removal
    // ==========================
    public static void checkMissingAndClean(String csvFile) {

        String line;
        String delimiter = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            int rowNumber = 0;

            while ((line = br.readLine()) != null) {
                rowNumber++;
                String[] values = line.split(delimiter, -1);

                for (int i = 0; i < values.length; i++) {

                    // Check missing or empty values
                    if (values[i].trim().isEmpty()) {
                        System.out.println("Row " + rowNumber +
                                ", Column " + (i + 1) +
                                ": Missing or Empty Value");
                    }
                    // Stopword removal for non-empty text
                    else {
                        String cleanedText = removeStopWords(values[i]);
                        System.out.println("Row " + rowNumber +
                                ", Column " + (i + 1) +
                                " after stopword removal: " + cleanedText);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ==========================
    // Part by Mydhily: Remove stopwords
    // ==========================
    public static String removeStopWords(String text) {
        StringBuilder result = new StringBuilder();
        String[] words = text.toLowerCase().split("\\s+");

        for (String word : words) {
            if (!stopWords.contains(word)) {
                result.append(word).append(" ");
            }
        }
        return result.toString().trim();
    }
}
