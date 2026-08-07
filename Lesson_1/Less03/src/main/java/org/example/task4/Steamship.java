package org.example.task4;

public class Steamship extends Device{
    private int passengers;
    private double length;

    public Steamship(String name, String description, int passengers, double length) {
        super(name, description);
        this.passengers = passengers;
        this.length = length;
    }

    @Override
    public void Sound(){
        System.out.println("Tooooot!");
    }

    @Override
    public void Show() {
        System.out.println("Name: " + getName());
    }

    @Override
    public void Desc() {
        System.out.println(getDescription());
        System.out.println("Passengers: " + passengers);
        System.out.println("Length: " + length + " m");
    }
}
