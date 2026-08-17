package org.example;

public class Passenger {
    // зберігається час появи пасажира
    // коли він прибув на причал
    private final int arrivalTime;

    public  Passenger(int arrivalTime){
        this.arrivalTime = arrivalTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }
}
