package org.example.task4;

public class Kettle extends Device{
    private int volume;
    private int power;

    public Kettle(String name, String description, int volume, int power) {
        super(name, description);
        this.volume = volume;
        this.power = power;
    }

    @Override
    public void Sound(){
        System.out.println("Whistle... Whistle...");
    }

    @Override
    public void Show() {
        System.out.println("Name: " + getName());
    }

    @Override
    public void Desc() {
        System.out.println(getDescription());
        System.out.println("Volume: " + volume + " L");
        System.out.println("Power: " + power + " W");
    }
}
