module com.example.lab2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.mephi.map to javafx.fxml;
    exports ru.mephi.map;
}