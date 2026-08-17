package org.example;

public class SimulationResult {
    private final double averageWaitTime;
    private final int maxQueueLength;
    private final int totalPassengersServed;

    public SimulationResult(double averageWaitTime, int maxQueueLength, int totalPassengersServed) {
        this.averageWaitTime = averageWaitTime;
        this.maxQueueLength = maxQueueLength;
        this.totalPassengersServed = totalPassengersServed;
    }

    public double getAverageWaitTime() {
        return averageWaitTime;
    }

    public int getMaxQueueLength() {
        return maxQueueLength;
    }

    public int getTotalPassengersServed() {
        return totalPassengersServed;
    }

    @Override
    public String toString() {
        return String.format(
                "Результати симуляції:\n" +
                        "- Середній час очікування пасажира: %.2f хв.\n" +
                        "- Обслуговувано пасажирів: %d\n" +
                        "- Максимальна черга на причалі: %d осіб",
                averageWaitTime, totalPassengersServed, maxQueueLength
        );
    }
}