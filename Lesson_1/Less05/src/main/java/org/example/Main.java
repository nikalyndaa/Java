package org.example;

public class Main {
    public static void main(String[] args) {
        // Симуляція протягом 24 годин (1440 хвилин)
        int simulationTime = 24 * 60;
        int minFreeSeats = 2;
        int maxFreeSeats = 10;
        int maxAllowedQueueN = 15; // N людей на зупинці

        PierSimulation simulation = new PierSimulation(simulationTime, minFreeSeats, maxFreeSeats);

        // Параметри інтервалів появи пасажирів (ранок, день, вечір, ніч) у хвилинах
        double passMorning = 2.0, passDay = 5.0, passEvening = 3.0, passNight = 15.0;

        double boatMorning = 10.0, boatDay = 15.0, boatEvening = 10.0, boatNight = 30.0;
        SimulationResult result = simulation.runSimulation(
                passMorning, passDay, passEvening, passNight,
                boatMorning, boatDay, boatEvening, boatNight,
                false, 50
        );

        System.out.println(result);

        System.out.println("\n--- Пошук оптимального інтервалу катерів для N = " + maxAllowedQueueN + " ---");

        double testBoatInterval = 20.0; // Початковий інтервал
        while (testBoatInterval > 1.0) {
            PierSimulation testSim = new PierSimulation(simulationTime, minFreeSeats, maxFreeSeats);
            SimulationResult res = testSim.runSimulation(
                    passMorning, passDay, passEvening, passNight,
                    testBoatInterval, testBoatInterval, testBoatInterval, testBoatInterval,
                    false, 50
            );

            if (res.getMaxQueueLength() <= maxAllowedQueueN) {
                System.out.printf("Достатній середній інтервал між катерами: %.1f хв. (Макс. черга: %d)\n",
                        testBoatInterval, res.getMaxQueueLength());
                break;
            }
            testBoatInterval -= 0.5;
        }
    }
}