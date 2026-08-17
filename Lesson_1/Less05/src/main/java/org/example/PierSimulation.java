package org.example;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class PierSimulation {

    //перший прийшов -- перший сів у катер FIFO

    private final Queue<Passenger> passengers = new LinkedList<>();
    private final Random random = new Random();

    private final int simulationTime;
    private final int minFreeSeats;
    private final int maxFreeSeats;

    public PierSimulation(int simulationTime,
                          int minFreeSeats,
                          int maxFreeSeats) {

        this.simulationTime = simulationTime;
        this.minFreeSeats = minFreeSeats;
        this.maxFreeSeats = maxFreeSeats;
    }

    // визначення середнього інтервалу появи пасажирів
    //     * залежно від часу доби.
    private double getPassengerInterval(int time, double morning,
                                        double day,
                                        double evening, double night){
        int hour = (time/60) % 24;

        if(hour >= 6 && hour < 10){
            return morning;
        }
        if(hour >= 10 && hour < 17){
            return day;
        }
        if(hour >= 17 && hour < 22){
            return evening;
        }
        return night;
    }

    // середній інтервал між катерами
    private double getBoatInterval(int time,
                                   double morning,
                                   double day,
                                   double evening,
                                   double night) {

        int hour = (time / 60) % 24;
        if (hour >= 6 && hour < 10) {
            return morning;
        }
        if (hour >= 10 && hour < 17) {
            return day;
        }
        if (hour >= 17 && hour < 22) {
            return evening;
        }
        return night;
    }

    private int randomInterval(double average) {
        int min = Math.max(1, (int) Math.round(average * 0.5));
        int max = Math.max(min, (int) Math.round(average * 1.5));
        return min + random.nextInt(max - min + 1);
    }

    private int randomFreeSeats() {

        return minFreeSeats +
                random.nextInt(maxFreeSeats - minFreeSeats + 1);
    }

    public SimulationResult runSimulation(
            double passMorning, double passDay, double passEvening, double passNight,
            double boatMorning, double boatDay, double boatEvening, double boatNight,
            boolean isTerminalStop, int maxCapacityIfTerminal) {

        int currentTime = 0;


        int nextPassengerIn = randomInterval(getPassengerInterval(currentTime, passMorning, passDay, passEvening, passNight));
        int nextBoatIn = randomInterval(getBoatInterval(currentTime, boatMorning, boatDay, boatEvening, boatNight));

        long totalWaitTime = 0;
        int totalPassengersServed = 0;
        int maxQueueLength = 0;

        while (currentTime < simulationTime){
            currentTime++;
            nextPassengerIn--;
            nextBoatIn--;

            //зявляється ноивй пасажир
            if(nextPassengerIn <=0){
                passengers.add(new Passenger(currentTime));
                nextPassengerIn = randomInterval(getPassengerInterval(currentTime, passMorning, passDay, passEvening, passNight));
            }

            //макс розмір черги
            if(passengers.size() > maxQueueLength){
                maxQueueLength = passengers.size();
            }

            // приюутя катера
            if (nextBoatIn <=0){
                int freeSeats = isTerminalStop ? maxCapacityIfTerminal : randomFreeSeats();

                while(freeSeats > 0 && !passengers.isEmpty()){
                    Passenger passenger = passengers.poll();
                    totalWaitTime += (currentTime - passenger.getArrivalTime());
                    totalPassengersServed++;
                    freeSeats--;
                }
                nextBoatIn = randomInterval(getBoatInterval(currentTime, boatMorning, boatDay, boatEvening, boatNight));

            }

        }
        double averageWaitTime = totalPassengersServed > 0 ? (double) totalWaitTime / totalPassengersServed : 0;
        return new SimulationResult(averageWaitTime, maxQueueLength, totalPassengersServed);

    }
}
