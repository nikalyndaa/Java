package org.example;

public class Boat {

    // отримуємо час прибуьья катера
    // кількість вільний мість
    // тип зупинкт
    private final int arriavalTime;
    private final int freeSeats;
    private final boolean terminalStop;

    public Boat(int arriavalTime, int freeSeats, boolean terminalStop){
        this.arriavalTime = arriavalTime;
        this.freeSeats = freeSeats;
        this.terminalStop = terminalStop;
    }

    public int getArriavalTime() {
        return arriavalTime;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public boolean isTerminalStop() {
        return terminalStop;
    }
}
