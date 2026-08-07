package org.example;

import java.util.Scanner;

public class Human {
    private String firstName;
    private String lastName;
    private int age;
    private String city;

    public Human(String firstName, String lastName,
                 int age, String city){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
    }

    private final Scanner scan = new Scanner(System.in);
    public void inputData(){
        this.firstName = scan.nextLine();
        this.lastName = scan.nextLine();
        this.age = scan.nextInt();
        this.city = scan.nextLine();

    }

    public String outputData() {
        return "Human\n" +
                "First name: " + firstName + "\n" +
                "Last name: " + lastName + "\n" +
                "Age: " + age + "\n" +
                "City: " + city;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
