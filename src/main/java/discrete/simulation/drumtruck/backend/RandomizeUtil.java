package discrete.simulation.drumtruck.backend;

public class RandomizeUtil {



    static  int getRandomWithDistribution(int[] values, double[] probabilities) {
        if (values.length != probabilities.length) {
            throw new IllegalArgumentException("Values and probabilities arrays must have the same length");
        }

        double randomValue = Math.random();
        double cumulativeProbability = 0.0;

        for (int i = 0; i < probabilities.length; i++) {
            cumulativeProbability += probabilities[i];
            if (randomValue < cumulativeProbability) {
                return values[i];
            }
        }

        // Fallback in case of precision issues
        return values[values.length - 1];
    }
}
