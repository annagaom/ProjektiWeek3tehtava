package org.example.projektiweek3tehtava.view;

import javafx.scene.control.*;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Output {
    LanguageGenerator languageGenerator = new LanguageGenerator();

    public void createCustomerOutput(String selectedLanguage,
                                     TitledPane titleLabel,
                                     Label languageLabel,
                                     Label firstNameLabel,
                                     Label lastNameLabel,
                                     Label emailLabel,
                                     Button saveButton) {
        Locale locale = languageGenerator.generateLanguage(selectedLanguage);
        ResourceBundle resourceBundle;

        try {
            resourceBundle = ResourceBundle.getBundle("messages", locale);
        } catch (MissingResourceException e) {
            System.out.println("Error: Resource bundle not found for locale: " + locale);
            return;
        }

        // Get language-specific messages from resource bundle
        try {
            titleLabel.setText(resourceBundle.getString("title"));
            languageLabel.setText(resourceBundle.getString("language"));
            firstNameLabel.setText(resourceBundle.getString("firstName"));
            lastNameLabel.setText(resourceBundle.getString("lastName"));
            emailLabel.setText(resourceBundle.getString("email"));
            saveButton.setText(resourceBundle.getString("save"));
        } catch (MissingResourceException e) {
            System.out.println("Error: Resource bundle not found for locale: " + locale);
        }

    }


}
