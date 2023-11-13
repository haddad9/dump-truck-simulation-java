package discrete.simulation.drumtruck.data;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import lombok.Data;

@Data

public class DistributionTableRow {
    private final IntegerProperty value;
    private final DoubleProperty probability;
    private final DoubleProperty cumulativeProbability;

    public DistributionTableRow(int value, double probability, double cumulativeProbability) {
        this.value = new SimpleIntegerProperty(value);
        this.probability = new SimpleDoubleProperty(probability);
        this.cumulativeProbability = new SimpleDoubleProperty(cumulativeProbability);
    }

    public int getValue() {
        return value.get();
    }

    public IntegerProperty valueProperty() {
        return value;
    }

    public double getProbability() {
        return probability.get();
    }

    public DoubleProperty probabilityProperty() {
        return probability;
    }

    public double getCumulativeProbability() {
        return cumulativeProbability.get();
    }

    public DoubleProperty cumulativeProbabilityProperty() {
        return cumulativeProbability;
    }
}
