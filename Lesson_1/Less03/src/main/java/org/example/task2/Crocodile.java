package org.example.task2;

public class Crocodile extends Animal {

    private String river;
    private double length;
    private int teethCount;

    public Crocodile(String name, int age, String color, double weight,
                     String river, double length, int teethCount) {

        super(name, age, color, weight);

        this.river = river;
        this.length = length;
        this.teethCount = teethCount;
    }

    public String IamCrocodile() {
        return "Hello, I am a crocodile.";
    }

    @Override
    public String outputData() {
        return super.outputData() +
                "\nRiver: " + river +
                "\nLength: " + length + " m" +
                "\nTeeth count: " + teethCount;
    }

    public String getRiver() {
        return river;
    }

    public double getLength() {
        return length;
    }

    public int getTeethCount() {
        return teethCount;
    }

    public void setRiver(String river) {
        this.river = river;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setTeethCount(int teethCount) {
        this.teethCount = teethCount;
    }
}