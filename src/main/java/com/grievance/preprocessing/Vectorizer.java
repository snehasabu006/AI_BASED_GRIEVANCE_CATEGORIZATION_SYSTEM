package main.java.com.grievance.preprocessing;

import java.io.*;
import java.util.*;

public class Vectorizer implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, Integer> vocabulary = new HashMap<>();
    private boolean useTFIDF = false;

    // Fit vectorizer on a list of documents
    public void fit(List<String> documents, boolean tfidf) {
        useTFIDF = tfidf;
        Set<String> vocabSet = new HashSet<>();
        int index = 0;

        for (String doc : documents) {
            String[] tokens = TextPreprocessor.cleanText(doc).split("\\s+");
            for (String token : tokens) {
                if (!token.isEmpty() && !vocabSet.contains(token)) {
                    vocabulary.put(token, index++);
                    vocabSet.add(token);
                }
            }
        }
        System.out.println("Vocabulary size: " + vocabulary.size());
    }

    // Transform single document into vector
    public double[] transform(String doc) {
        double[] vector = new double[vocabulary.size()];
        String[] tokens = TextPreprocessor.cleanText(doc).split("\\s+");

        for (String token : tokens) {
            if (vocabulary.containsKey(token)) {
                vector[vocabulary.get(token)] += 1.0;
            }
        }

        if (useTFIDF) {
            // For simplicity, just frequency * log(1 + vocab size / df) placeholder
            // Actual TF-IDF to be handled later with trained model
        }
        return vector;
    }

    // Save vectorizer
    public void save(String path) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(this);
            System.out.println("Vectorizer saved at: " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load vectorizer
    public static Vectorizer load(String path) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            return (Vectorizer) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Map<String, Integer> getVocabulary() {
        return vocabulary;
    }
}
