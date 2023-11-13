package discrete.simulation.drumtruck.backend;

import lombok.Data;

@Data
public class FEL implements Comparable<FEL>{
    private EventNotice event;
    private int endTime;
    private Truck t;
    private int startTime;

    public FEL(EventNotice eventNotice, int startTime,int endTime, Truck t) {
        this.startTime = startTime;
        this.event = eventNotice;
        this.endTime = endTime;
        this.t = t;
    }

    public String test(String test) {
        return test;
    }

    public int busyTime() {
        return endTime - startTime;
    }
    @Override
    public String toString() {
        return "(" + event + ", " + endTime + ", " + t + ")";
    }

    @Override
//    compare in ascending order
    public int compareTo(FEL fel) {
        return this.endTime - fel.endTime;
    }
}
