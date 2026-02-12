package main.java.com.grievance.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class ClassDistribution {

    // ==========================
    // Task by Pooja: Class Distribution
    // ==========================
    public static void printClassDistribution(String filePath, int categoryColumnIndex) {

        Map<String, Integer> categoryCount = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length > categoryColumnIndex) {
                    String category = parts[categoryColumnIndex];

                    categoryCount.put(
                            category,
                            categoryCount.getOrDefault(category, 0) + 1
                    );
                }
            }

            System.out.println("\n===== CLASS DISTRIBUTION =====");
            for (Map.Entry<String, Integer> entry : categoryCount.entrySet()) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
