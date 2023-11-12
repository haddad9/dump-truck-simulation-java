package discrete.simulation.drumtruck.backend;
import lombok.Data;

@Data
public class Truck {
    int truckNumber;
    int travelTime;
    int loadTime;
    int weighTime;

    @Override
    public String toString() {
        return "DT"+ truckNumber+" ";
    }
}
