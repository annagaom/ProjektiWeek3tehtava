module org.example.projektiweek3tehtava {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;


    opens org.example.projektiweek3tehtava to javafx.fxml;
    exports org.example.projektiweek3tehtava;
    exports org.example.projektiweek3tehtava.entity;
    opens org.example.projektiweek3tehtava.entity to javafx.fxml;
}