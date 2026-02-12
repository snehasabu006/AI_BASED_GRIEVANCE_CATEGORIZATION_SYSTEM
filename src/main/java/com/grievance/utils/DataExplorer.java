package main.java.com.grievance.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class DataExplorer {

    // ==========================
    // Task by Riya: Data Exploration
    // ==========================
    public static void exploreDataset(String filePath, int textColumnIndex) {

        String line;
        String delimiter = ",";

        Set<String> uniqueRows = new HashSet<>();

        int rowCount = 0;
        int duplicateCount = 0;
        int totalTextLength = 0;
        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                rowCount++;

                if (!uniqueRows.add(line)) {
                    duplicateCount++;
                }

                String[] values = line.split(delimiter, -1);
                String text = values[textColumnIndex].trim();

                int length = text.length();
                totalTextLength += length;

                minLength = Math.min(minLength, length);
                maxLength = Math.max(maxLength, length);
            }

            double averageLength = (rowCount > 0) ? (double) totalTextLength / rowCount : 0;

            System.out.println("\n===== DATA EXPLORATION =====");
            System.out.println("Total Rows: " + rowCount);
            System.out.println("Duplicate Rows: " + duplicateCount);
            System.out.println("Min Text Length: " + minLength);
            System.out.println("Max Text Length: " + maxLength);
            System.out.println("Avg Text Length: " + averageLength);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
