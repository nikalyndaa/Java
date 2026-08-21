package org.example;

public class Main {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        System.out.println("Task1");
        task1.lambdaRun();
        Task2.Fraction f = new Task2.Fraction(1,1);
        System.out.println("Task2");
        f.lambdaRun();
        System.out.println("Task3");
        new Task3().lambdaRun();

        System.out.println("Task4");
        new Task4().lambdaRun();



    }
}