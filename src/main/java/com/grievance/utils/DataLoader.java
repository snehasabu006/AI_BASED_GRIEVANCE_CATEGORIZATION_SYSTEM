package main.java.com.grievance.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import main.java.com.grievance.preprocessing.TextPreprocessor;

public class DataLoader {

    // =======================
    // TASK by Sneha: Inspect Dataset
    // =======================
    public static void inspectDataset(String filePath) {
        String line;
        String csvSplitBy = ",";

        int rowCount = 0;
        int columnCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String header = br.readLine();
            if (header == null) {
                System.out.println("Dataset is empty!");
                return;
            }

            String[] columns = header.split(csvSplitBy);
            columnCount = columns.length;

            System.out.println("===== DATASET INFO =====");
            System.out.println("Number of columns: " + columnCount);

            for (int i = 0; i < columns.length; i++) {
                System.out.println((i + 1) + ". " + columns[i]);
            }

            System.out.println("\n===== SAMPLE ROWS =====");

            int printed = 0;
            while ((line = br.readLine()) != null && printed < 5) {
                rowCount++;
                System.out.println(line);
                printed++;
            }

            System.out.println("\nTotal Rows (approx): " + rowCount);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ==========================================
    // TASK by Sneha: Load & Clean Text Column
    // ==========================================
    public static void loadAndCleanTextColumn(String filePath, int textColumnIndex) {
        String line;
        String csvSplitBy = ",";

        System.out.println("\n===== CLEANED TEXT SAMPLE =====");

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            br.readLine(); // skip header
            int count = 0;

            while ((line = br.readLine()) != null && count < 5) {
                String[] data = line.split(csvSplitBy);

                if (data.length > textColumnIndex) {
                    String originalText = data[textColumnIndex];
                    String cleanedText = TextPreprocessor.cleanText(originalText);

                    System.out.println("Original: " + originalText);
                    System.out.println("Cleaned : " + cleanedText);
                    System.out.println("---------------------------");
                    count++;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

