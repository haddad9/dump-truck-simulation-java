package discrete.simulation.drumtruck.backend;

public class FEL {
    EventNotice event;
    int time;
    int truckNumber;



    @Override
    public String toString() {
        return "(" + event + ", " + time + ", DT" + truckNumber + ")";
    }
}
