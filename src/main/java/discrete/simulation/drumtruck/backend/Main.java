package discrete.simulation.drumtruck.backend;

public class Main {
    public static void main(String[] args) {
        SystemSimulation systemSimulation = new SystemSimulation(
                10000,6,
                new int[] {5,10,15}, new double[] {0.3,0.5,0.2},
                new int[] {12,16}, new double[] {0.7,0.3},
                new int[]{40,60,80,10}, new double[] {0.4, 0.3, 0.2, 0.1});
        systemSimulation.simulate();
    }
}
