package discrete.simulation.drumtruck.controller;

import discrete.simulation.drumtruck.data.DistributionTableRow;
import discrete.simulation.drumtruck.data.DistributionTable;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;


public class SimulationUIController implements Initializable {

    @FXML
    public void startSimulation(ActionEvent actionEvent) {

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
