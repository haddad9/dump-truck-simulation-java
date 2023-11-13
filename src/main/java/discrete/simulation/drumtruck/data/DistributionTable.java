package discrete.simulation.drumtruck.data;

import discrete.simulation.drumtruck.data.DistributionTableRow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class DistributionTable {
    private ObservableList<DistributionTableRow> rows;

    public DistributionTable(int[] values, double[] probabilities) {
        this.rows = FXCollections.observableArrayList();

        double cumulativeProbability = 0;
        for (int i = 0; i < values.length; i++) {
            cumulativeProbability += probabilities[i];
            rows.add(new DistributionTableRow(values[i], probabilities[i], cumulativeProbability));

        }
    }

    public ObservableList<DistributionTableRow> getRows() {
        return rows;
    }
}
