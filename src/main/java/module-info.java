module org.example.projektiweek3tehtava {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires jakarta.persistence;  // Add other modules if needed, like Hibernate

    exports org.example.projektiweek3tehtava to javafx.graphics;
    opens org.example.projektiweek3tehtava to javafx.fxml;

}

