package discrete.simulation.drumtruck.controller;

import discrete.simulation.drumtruck.data.ResultRow;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import lombok.Data;


@Data
public class ResultUIController{

    private ObservableList<ResultRow> resultRows;

    @FXML
    private TableView<ResultRow> resultTable;
    @FXML
    public void statistics() {
        Stage stage = new Stage();
        stage.setTitle("Statistics Busy Time");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Clock");
        yAxis.setLabel("Busy Time");
        final LineChart<Number,Number> lineChart =
                new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("Loader vs Scaler Busy Time");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Loader Busy Time");
        for (ResultRow resultRow: resultRows
             ) {
            series1.getData().add(new XYChart.Data(resultRow.getClock(), resultRow.getBusyLoaderTime()));
        }
        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Scaler Busy Time");
        for (ResultRow resultRow: resultRows
        ) {
            series2.getData().add(new XYChart.Data(resultRow.getClock(), resultRow.getBusyScalerTime()));
        }
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().addAll(series1,series2);
        stage.setScene(scene);
        stage.show();



        Stage stage2 = new Stage();
        stage2.setTitle("Statistics Total in Queue");
        final NumberAxis xAxis2 = new NumberAxis();
        final NumberAxis yAxis2 = new NumberAxis();
        xAxis2.setLabel("Clock");
        yAxis2.setLabel("Total Truck in Queue");
        final LineChart<Number,Number> lineChart2 =
                new LineChart<Number,Number>(xAxis2,yAxis2);
        lineChart2.setTitle("Loader vs Scaler Total Truck in Queue");
        XYChart.Series seriesQ1 = new XYChart.Series();
        seriesQ1.setName("Loader Queue ");
        for (ResultRow resultRow: resultRows
        ) {
            seriesQ1.getData().add(new XYChart.Data(resultRow.getClock(), resultRow.getLQt()));
        }
        XYChart.Series seriesQ2 = new XYChart.Series();
        seriesQ2.setName("Scaler Queue");
        for (ResultRow resultRow: resultRows
        ) {
            seriesQ2.getData().add(new XYChart.Data(resultRow.getClock(), resultRow.getWQt()));
        }
        Scene scene2  = new Scene(lineChart2,800,600);
        lineChart2.getData().addAll(seriesQ1,seriesQ2);
        stage2.setScene(scene2);
        stage2.show();
    }

    public void setRows(ObservableList<ResultRow> resultRows) {
        this.resultRows = resultRows;
        resultTable.setItems(resultRows);

    }


}
