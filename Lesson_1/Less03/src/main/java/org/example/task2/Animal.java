package org.example.task2;

public class Animal {
    private String name;
    private int age;
    private String color;
    private double weight;

    public Animal(String name, int age, String color, double weight) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.weight = weight;
    }
    public String outputData() {
        return "Animal\n" +
                "Name: " + name +
                "\nAge: " + age +
                "\nColor: " + color +
                "\nWeight: " + weight + " kg";
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


}

