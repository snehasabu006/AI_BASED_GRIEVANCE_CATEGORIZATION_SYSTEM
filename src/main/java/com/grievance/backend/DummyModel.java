package main.java.com.grievance.backend;

import java.io.Serializable;

public class DummyModel implements Serializable {

    // Dummy predict method (until ML model comes)
    public String predict(String text) {

        text = text.toLowerCase();

        if (text.contains("water") || text.contains("road")) {
            return "Infrastructure Issue";
        }

        if (text.contains("exam") || text.contains("teacher")) {
            return "Education Issue";
        }

        return "General Complaint";
    }
}
