package discrete.simulation.drumtruck.backend;

import lombok.Data;

@Data
public class FEL implements Comparable<FEL>{
    private EventNotice event;
    private int time;
    private Truck t;

    public FEL(EventNotice eventNotice, int time, Truck t) {
        this.event = eventNotice;
        this.time = time;
        this.t = t;
    }

    public String test(String test) {
        return test;
    }

    @Override
    public String toString() {
        return "(" + event + ", " + time + ", " + t + ")";
    }

    @Override
//    compare in ascending order
    public int compareTo(FEL fel) {
        return this.time - fel.time;
    }
}
