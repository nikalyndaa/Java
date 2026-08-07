package org.example.task2;

public class Kangaroo extends Animal {

    private double jumpLength;
    private String country;
    private boolean pouch;

    public Kangaroo(String name, int age, String color, double weight,
                    double jumpLength, String country, boolean pouch) {

        super(name, age, color, weight);

        this.jumpLength = jumpLength;
        this.country = country;
        this.pouch = pouch;
    }

    public String IamKangaroo() {
        return "Hello, I am a kangaroo.";
    }

    @Override
    public String outputData() {
        return super.outputData() +
                "\nJump length: " + jumpLength + " m" +
                "\nCountry: " + country +
                "\nHas pouch: " + pouch;
    }

    public double getJumpLength() {
        return jumpLength;
    }

    public String getCountry() {
        return country;
    }

    public boolean isPouch() {
        return pouch;
    }

    public void setJumpLength(double jumpLength) {
        this.jumpLength = jumpLength;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPouch(boolean pouch) {
        this.pouch = pouch;
    }
}