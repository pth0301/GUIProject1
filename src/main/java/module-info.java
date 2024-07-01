module org.example.guiproject1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.web;
    requires com.almasb.fxgl.scene;
    requires java.net.http;
    requires jakarta.json;
    requires jdk.httpserver;

    opens Controller to javafx.fxml;
    exports Controller;
    exports Features;
    opens Features to javafx.fxml;
}
