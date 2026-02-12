package main.java.com.grievance.backend;

import java.io.*;

public class ModelPersistence {

    // Save model/vectorizer object into file
    public static void saveObject(Object obj, String fileName) {

        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(fileName))) {

            out.writeObject(obj);
            System.out.println("✅ Saved successfully: " + fileName);

        } catch (IOException e) {
            System.out.println("❌ Error while saving: " + fileName);
            e.printStackTrace();
        }
    }

    // Load model/vectorizer object back from file
    public static Object loadObject(String fileName) {

        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(fileName))) {

            System.out.println("✅ Loaded successfully: " + fileName);
            return in.readObject();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("❌ Error while loading: " + fileName);
            e.printStackTrace();
        }

        return null;
    }
}
