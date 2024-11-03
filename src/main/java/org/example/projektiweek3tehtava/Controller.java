package org.example.projektiweek3tehtava;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Controller {
    private static Stage primaryStage;

    @FXML
    private ChoiceBox<String> languageChoiceBox;
    @FXML
    private TextField firstNameField, lastNameField, emailField;
    @FXML
    private Button saveButton;

    @FXML
    private Label titleLabel, languageLabel, firstNameLabel, lastNameLabel, emailLabel;

    @FXML
    public void initialize() {
        loadLabels(Locale.getDefault());

        // Set up the ChoiceBox
        languageChoiceBox.setValue("English"); // Set default language
        languageChoiceBox.setOnAction(event -> changeLanguage());

        // Set up saveButton action
        saveButton.setOnAction(event -> saveCustomer());
    }

    @FXML
    private void loadLabels(Locale locale) {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
            titleLabel.setText(bundle.getString("title"));
            languageLabel.setText(bundle.getString("language"));
            firstNameLabel.setText(bundle.getString("firstname"));
            lastNameLabel.setText(bundle.getString("lastname"));
            emailLabel.setText(bundle.getString("email"));
            saveButton.setText(bundle.getString("save"));
        } catch (MissingResourceException e) {
            System.out.println("Resource bundle not found for locale: " + locale);
        }
    }

    private String changeLanguage() {
        String selectedLanguage = languageChoiceBox.getValue();
        Locale locale;

        switch (selectedLanguage) {
            case "Farsi":
                locale = new Locale("fa", "IR");
                break;
            case "Japanese":
                locale = new Locale("ja", "JP");
                break;
            default:
                locale = new Locale("en", "US");
                break;
        }
        loadLabels(locale);
        return selectedLanguage;
    }

    @FXML
    private void saveCustomer() {
        final String DB_URL = "jdbc:mysql://localhost:3306/LocalizedDatabase";
        final String DB_USER = "root";
        final String DB_PASSWORD = "root";

        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String selectedLanguage = changeLanguage();

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty()) {
            showAlert("All fields must be filled in.");
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            switch (selectedLanguage) {
                case "English" -> addEmployeeEn(conn, firstName, lastName, email);
                case "Japanese" -> addEmployeeJa(conn, firstName, lastName, email);
                case "Farsi" -> addEmployeeFa(conn, firstName, lastName, email);
            }
            firstNameField.clear();
            lastNameField.clear();
            emailField.clear();
        } catch (SQLException e) {
            e.printStackTrace();
            showAlert("Error saving data to the database.");
        }
    }

    private void addEmployeeEn(Connection conn, String firstName, String lastName, String email) throws SQLException {
        String sql = "INSERT INTO employee_en(first_name, last_name, email) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.executeUpdate();
            showAlert("Employee added successfully.");
        }
    }

    private void addEmployeeFa(Connection conn, String firstName, String lastName, String email) throws SQLException {
        String sql = "INSERT INTO employee_fa(first_name, last_name, email) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.executeUpdate();
            showAlert("Employee added successfully.");
        }
    }

    private void addEmployeeJa(Connection conn, String firstName, String lastName, String email) throws SQLException {
        String sql = "INSERT INTO employee_ja(first_name, last_name, email) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.setString(3, email);
            stmt.executeUpdate();
            showAlert("Employee added successfully.");
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }
}
