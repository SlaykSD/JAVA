module com.example.lab2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;


    opens ru.mephi.homeworks.hw1.map to javafx.fxml;
    exports ru.mephi.homeworks.hw1.map;
    exports ru.mephi.labs.lab1.list;
    opens ru.mephi.labs.lab1.list to javafx.fxml;
}