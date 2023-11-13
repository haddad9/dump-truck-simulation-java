package discrete.simulation.drumtruck;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SimulationApp extends Application{
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SimulationApp.class.getResource("simulation-ui.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 675);
        scene.getStylesheets().add(String.valueOf(SimulationApp.class.getResource("style.css")));
        stage.setTitle("Dump Truck Simulation — Haddad");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
