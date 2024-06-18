module org.example.santiexameninterfaces {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;
    requires jasperreports;


    opens org.example.santiexameninterfaces to javafx.fxml;
    exports org.example.santiexameninterfaces;
}