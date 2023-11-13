module discrete.simulation.drumtruck {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires lombok;
    opens discrete.simulation.drumtruck.controller to javafx.fxml;
    opens discrete.simulation.drumtruck to javafx.fxml;
    exports discrete.simulation.drumtruck;
    exports discrete.simulation.drumtruck.controller;
    opens discrete.simulation.drumtruck.data to javafx.base;

}