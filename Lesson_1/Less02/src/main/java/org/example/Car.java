package org.example;

import java.util.Scanner;

public class Car {
    private String name;
    private String manufacture;
    private int year;
    private double volume;

    public Car(String name, String manufacture, int year, double volume){
        this.name = name;
        this.manufacture = manufacture;
        this.year = year;
        this.volume = volume;
    }

    public Car(){
        this(" ", " ",0, 0.0);

    }

    public void inputData(String name, String manufacture, int year, double volume) {
        this.name = name;
        this.manufacture = manufacture;
        this.year = year;
        this.volume = volume;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public int getYear() {
        return year;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setYear(int year) {
        this.year = year;
    }

    private  final Scanner sc = new Scanner(System.in);
    public void inputData() {

        System.out.print("enter name: ");
        name = sc.nextLine();

        System.out.print("enter manufacture: ");
        manufacture = sc.nextLine();

        System.out.print("enter year: ");
        year = sc.nextInt();
        sc.nextLine();

        System.out.print("enter volume: ");
        volume = sc.nextDouble();

    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", year=" + year +
                ", volume=" + volume +
                '}';
    }
}
