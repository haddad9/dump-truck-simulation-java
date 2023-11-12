package discrete.simulation.drumtruck.backend;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

@Data
public class SystemSimulation {
    private Queue<FEL> fel;
    private Queue<Truck> loadQ; //loaded queue
    private Queue<Truck> weighQ; //weighing queue
    private int clock=0;
    private int LQt; //num of truck in the loader queue
    private int WQt; //num of truck in the weighing queue
    private int Wt; //num of truck being weighed (0,1)
    private int Lt; //num of loaded truck in the system (0,1,2)
    private  int simulationTime;

    public SystemSimulation(int simulationTime,  int numTruck, int[] valuesLoad, double[] probabilitiesLoad, int[] valuesWeigh, double[] probabilitiesWeigh, int[] valuesTravel, double[] probabilitiesTravel ) {
        this.simulationTime = simulationTime;
        this.loadQ = new LinkedList<>();
        this.weighQ = new LinkedList<>();
        this.fel = new PriorityQueue<>();
        for (int i = 0; i < numTruck; i++) {
            Truck t = new Truck();
            t.setTruckNumber(i);
            t.setTravelTime(RandomizeUtil.getRandomWithDistribution(valuesTravel, probabilitiesTravel));
            t.setLoadTime(RandomizeUtil.getRandomWithDistribution(valuesLoad, probabilitiesLoad));
            t.setWeighTime(RandomizeUtil.getRandomWithDistribution(valuesWeigh, probabilitiesWeigh));
            loadQ.add(t);
        }
        fel.add(new FEL(EventNotice.EL, clock+loadQ.peek().loadTime, loadQ.poll()));
        fel.add(new FEL(EventNotice.EL, clock+loadQ.peek().loadTime, loadQ.poll()));
        Lt =2;

    }

    public void simulate(){
        System.out.println("CLOCK === LQt === WQt === Wt === Lt === LOADQ === WEIGHQ === FEL");
        while ( clock < simulationTime){
            FEL felEvent = fel.poll();
            clock = felEvent.getTime();
            switch (felEvent.getEvent()){

                case ALQ:
                    if(loadQ.isEmpty()) {
                        if (Lt != 2) {
                            Lt++;
                            Truck t = felEvent.getT();
                            fel.add(new FEL(EventNotice.EL, clock + t.loadTime, t));
                        } else {
                            loadQ.add(felEvent.getT());
                        }
                    } else {
                        loadQ.add(felEvent.getT());

                    }
                    break;
                case EL:
                    Lt--;
                    if(!loadQ.isEmpty()){
                        Truck t = loadQ.poll();
                        fel.add(new FEL(EventNotice.EL, clock+t.loadTime, t));

                    }
                    else {
                        Lt++;
                        Truck t =felEvent.getT();
                        fel.add(new FEL(EventNotice.EL, clock+t.loadTime, felEvent.getT()));
                    }
                    if (weighQ.isEmpty()){
                        if(Wt==0){
                            Wt++;
                            Truck t = felEvent.getT();
                            fel.add(new FEL(EventNotice.EW, clock+t.weighTime, t));
                        } else{
                            weighQ.add(felEvent.getT());
                        }
                    } else{
                        weighQ.add(felEvent.getT());
                    }
                    break;
                case EW:
                    Wt--;
                    if(!weighQ.isEmpty()){
                        Wt++;
                        Truck t = weighQ.poll();
                        fel.add(new FEL(EventNotice.EW, clock+t.weighTime, t));
                    }
                    Truck t = felEvent.getT();
                    fel.add(new FEL(EventNotice.ALQ, clock+t.travelTime, t));
                    break;
            }
            LQt = loadQ.size();
            WQt = weighQ.size();
            String loadqString = loadQ.stream().map(Truck::toString).reduce("", (acc, val) -> acc + val);
            String weighqString = weighQ.stream().map(Truck::toString).reduce("", (acc, val) -> acc + val);
            String felString = fel.stream().map(FEL::toString).reduce("", (acc, val) -> acc + val);
            System.out.println(String.
                    format("%s ===  %s === %s ===  %s === %s === %s === %s === %s ",
                            clock,LQt,WQt, Wt, Lt, loadqString, weighqString, felString));
        }
    }

}
