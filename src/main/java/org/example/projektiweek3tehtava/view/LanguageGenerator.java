package org.example.projektiweek3tehtava.view;

import java.util.Locale;

public class LanguageGenerator {
    public Locale generateLanguage(String selectedLanguage) {
       Locale locale;

        // Create locale based on language code
        switch (selectedLanguage) {
            case "English":
                locale = new Locale("en", "US");
                break;
            case "Farsi":
                locale = new Locale("fa", "IR");
                break;
            case "Japanese":
                locale = new Locale("ja", "JP");
                break;
            default:
                System.out.println("Error: Unsupported language code.");
                return null;
        }
        return locale;
    }
}
