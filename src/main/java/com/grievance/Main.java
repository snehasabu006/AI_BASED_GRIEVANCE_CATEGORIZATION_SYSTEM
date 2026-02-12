package main.java.com.grievance;

import main.java.com.grievance.utils.DataLoader;
import main.java.com.grievance.utils.DataExplorer;
import main.java.com.grievance.utils.ClassDistribution;
import main.java.com.grievance.preprocessing.CSVMissingCheck;   // <-- ADD THIS

public class Main {
    public static void main(String[] args) {

        String path = "data/raw/grievance.csv";

        // ================================
        // Task by Sneha: Inspect dataset
        // ================================
        DataLoader.inspectDataset(path);

        // ==========================================
        // Task by Sneha: Load and clean text column
        // ==========================================
        DataLoader.loadAndCleanTextColumn(path, 1);

        // ==========================================
        // Task by Riya: Data exploration
        // ==========================================
        DataExplorer.exploreDataset(path, 0);

        // ==========================================
        // Task by Pooja: Class distribution
        // ==========================================
        ClassDistribution.printClassDistribution(path, 1);

        // ==========================================
        // Task by Mydhily: Check missing / empty values
        // ==========================================
        CSVMissingCheck.checkMissingAndClean(path);
    }
}
