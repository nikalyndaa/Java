package org.example.task4;

public class Car extends Device{
    private String brand;
    private int maxSpeed;

    public Car(String name, String description,String brand, int maxSpeed) {
        super(name, description);
        this.brand = brand;
        this.maxSpeed = maxSpeed;

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
        System.out.println("Brand: " + brand);
        System.out.println("Max speed: " + maxSpeed + " km/h");
    }
}
