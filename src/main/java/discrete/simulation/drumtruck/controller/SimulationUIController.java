package discrete.simulation.drumtruck.controller;

import discrete.simulation.drumtruck.SimulationApp;
import discrete.simulation.drumtruck.backend.SystemSimulation;
import discrete.simulation.drumtruck.data.DistributionTableRow;
import discrete.simulation.drumtruck.data.DistributionTable;
import discrete.simulation.drumtruck.data.ResultRow;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class SimulationUIController implements Initializable {

    @FXML
    public TextField numTrucks;
    @FXML
    public TextField simulationTime;

    @FXML
    public void startSimulation() throws IOException {
        try {
//            start simulation
            SystemSimulation systemSimulation = new SystemSimulation(
                    Integer.parseInt(simulationTime.getText()),Integer.parseInt(numTrucks.getText()),
                    new int[] {5,10,15}, new double[] {0.3,0.5,0.2},
                    new int[] {12,16}, new double[] {0.7,0.3},
                    new int[]{40,60,80,10}, new double[] {0.4, 0.3, 0.2, 0.1});
            ObservableList<ResultRow> resultRows = systemSimulation.simulate();


            FXMLLoader loader = new FXMLLoader(SimulationApp.class.getResource("result-ui.fxml"));
            Scene scene = new Scene(loader.load(), 1200, 675);

            // Set up the controller for the pop-up window
            ResultUIController resultController = loader.getController();
            // Pass the value of numTrucksField to the new window
            resultController.setRows(resultRows);
            Stage resultStage = new Stage();
            resultStage.initModality(Modality.APPLICATION_MODAL);
            resultStage.setTitle("Simulation Result");

            resultStage.setScene(scene);
            resultStage.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @FXML
    private TableView<DistributionTableRow> loadingDistribution;

    @FXML
    private TableView<DistributionTableRow> weighingDistribution;

    @FXML
    private TableView<DistributionTableRow> travelDistribution;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Create data for your distribution table
        DistributionTable travelDistributionTable = new DistributionTable(
                new int[]{40,60,80,10}, new double[] {0.4, 0.3, 0.2, 0.1});
        // Populate TableView instances with data
        populateTable(travelDistribution, travelDistributionTable.getRows());

        DistributionTable loadDistributionTable = new DistributionTable(
                new int[]{5, 10, 15}, new double[]{0.3, 0.5, 0.2});
        // Populate TableView instances with data
        populateTable(loadingDistribution, loadDistributionTable.getRows());

        DistributionTable weighDistributionTable = new DistributionTable(
                new int[] {12,16}, new double[] {0.7,0.3});
        // Populate TableView instances with data
        populateTable(weighingDistribution, weighDistributionTable.getRows());



    }

    private void populateTable(TableView<DistributionTableRow> tableView, ObservableList<DistributionTableRow> data) {
//      get column
        tableView.setItems(data);
        TableColumn<DistributionTableRow, Integer> tcTime = (TableColumn<DistributionTableRow, Integer>) tableView.getColumns().get(0);
        TableColumn<DistributionTableRow, Integer> tcDist = (TableColumn<DistributionTableRow, Integer>) tableView.getColumns().get(1);
        TableColumn<DistributionTableRow, Integer> tcCuml = (TableColumn<DistributionTableRow, Integer>) tableView.getColumns().get(2);

        tcTime.prefWidthProperty().bind(tableView.widthProperty()
                        .divide(3));
        tcCuml.prefWidthProperty().bind(tableView.widthProperty()
                .divide(3));
        tcDist.prefWidthProperty().bind(tableView.widthProperty()
                .divide(3));

    }
}
