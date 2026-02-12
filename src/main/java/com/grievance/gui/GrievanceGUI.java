package main.java.com.grievance.gui;

import main.java.com.grievance.preprocessing.Vectorizer;
import main.java.com.grievance.preprocessing.TextPreprocessor;

import javax.swing.*;
import java.awt.*;

public class GrievanceGUI {

    private JFrame frame;
    private JTextArea complaintArea;
    private JButton predictButton, clearButton;
    private Vectorizer vectorizer;

    public GrievanceGUI(Vectorizer vec) {
        this.vectorizer = vec;
        initialize();
    }

    private void initialize() {
        frame = new JFrame("AI-Based Grievance Categorization");
        frame.setBounds(100, 100, 500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel lbl = new JLabel("Enter Grievance / Complaint Text:");
        lbl.setFont(new Font("Arial", Font.BOLD, 16));
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(lbl, BorderLayout.NORTH);

        complaintArea = new JTextArea();
        complaintArea.setLineWrap(true);
        complaintArea.setWrapStyleWord(true);
        complaintArea.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(complaintArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        predictButton = new JButton("Predict");
        clearButton = new JButton("Clear");
        predictButton.setFont(new Font("Arial", Font.BOLD, 14));
        clearButton.setFont(new Font("Arial", Font.BOLD, 14));

        buttonPanel.add(predictButton);
        buttonPanel.add(clearButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        clearButton.addActionListener(e -> complaintArea.setText(""));

        predictButton.addActionListener(e -> {
            String text = complaintArea.getText().trim();
            if (text.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Input cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String cleaned = TextPreprocessor.cleanText(text);
            double[] vector = vectorizer.transform(cleaned);

            JOptionPane.showMessageDialog(frame,
                    "Vectorized Input Length: " + vector.length,
                    "Info",
                    JOptionPane.INFORMATION_MESSAGE);

            // Backend prediction to be implemented by Mydhily
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        Vectorizer vec = Vectorizer.load("models/vectorizer.ser");
        if (vec == null) vec = new Vectorizer();
        new GrievanceGUI(vec);
    }
}
