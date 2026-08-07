package org.example.task4;

public class Microwave extends Device{
    private int power;
    private int capacity;

    public Microwave(String name, String description, int capacity, int power) {
        super(name, description);
        this.capacity = capacity;
        this.power = power;
    }

    @Override
    public void Sound(){
        System.out.println("Beep! Beep!");
    }

    @Override
    public void Show() {
        System.out.println("Name: " + getName());
    }

    @Override
    public void Desc() {
        System.out.println(getDescription());
        System.out.println("Capacity: " + capacity + " L");
        System.out.println("Power: " + power + " W");
    }
}
