package org.example.projektiweek3tehtava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Gui extends Application {
    private static Stage primaryStage;

    @Override
    public void start(Stage stage) throws IOException {
        Locale.setDefault(new Locale("en", "US"));
        primaryStage = stage;
        loadScene("messages", Locale.getDefault());  // Default to "bundle"
        primaryStage.show();
    }

    public static void loadScene(String bundleName, Locale locale) throws IOException {
        ResourceBundle resourceBundle;
        try {
            // Try to load the specified locale
            resourceBundle = ResourceBundle.getBundle(bundleName, locale);
        } catch (MissingResourceException e) {
            // Fallback to the default locale (en_US) if specified bundle is not found
            System.out.println("Warning: Resource bundle not found for locale: " + locale + ". Falling back to en_US.");
            resourceBundle = ResourceBundle.getBundle(bundleName, new Locale("en", "US"));
        }

        FXMLLoader fxmlLoader = new FXMLLoader(Gui.class.getResource("hello-view.fxml"));
        fxmlLoader.setResources(resourceBundle);
        Scene scene = new Scene(fxmlLoader.load(), 350, 340);

        primaryStage.setScene(scene);
    }


    public static void main(String[] args) {
        launch();
    }
}
