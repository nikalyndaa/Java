package org.example.task2;

public class Tiger extends Animal {

    private String stripeColor;
    private String habitat;
    private int speed;

    public Tiger(String name, int age, String color, double weight,
                 String stripeColor, String habitat, int speed) {

        super(name, age, color, weight);

        this.stripeColor = stripeColor;
        this.habitat = habitat;
        this.speed = speed;
    }

    public String IamTiger() {
        return "Hello, I am a tiger.";
    }

    @Override
    public String outputData() {
        return super.outputData() +
                "\nStripe color: " + stripeColor +
                "\nHabitat: " + habitat +
                "\nSpeed: " + speed + " km/h";
    }

    public String getStripeColor() {
        return stripeColor;
    }

    public String getHabitat() {
        return habitat;
    }

    public int getSpeed() {
        return speed;
    }

    public void setStripeColor(String stripeColor) {
        this.stripeColor = stripeColor;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}