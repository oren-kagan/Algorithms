module org.example.graphviewer {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;

    opens org.example.graphviewer to javafx.fxml;
    exports org.example.graphviewer;
}