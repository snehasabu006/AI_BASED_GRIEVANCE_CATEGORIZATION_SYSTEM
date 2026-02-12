package main.java.com.grievance.backend;

public class ModelTest {

    public static void runModelTest() {
        // ================================
        // Task by Riya: Model Saving + Loading Test
        // ================================
        DummyModel model = new DummyModel();
        // Save dummy model
        ModelPersistence.saveObject(model, "model.ser");

        // Load dummy model
        DummyModel loadedModel =
                (DummyModel) ModelPersistence.loadObject("model.ser");
        // Test prediction
        String output = loadedModel.predict("No water supply in hostel");
        System.out.println("\n===== MODEL TEST OUTPUT =====");
        System.out.println("Prediction: " + output);
    }
}
