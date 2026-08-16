package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        Matrix<Double> matrix1 =
                new Matrix<>(3, 3, value -> value);

        Matrix<Double> matrix2 =
                new Matrix<>(3, 3, value -> value);

        // Випадкове заповнення
        matrix1.fillRandom(1, 10, random);
        matrix2.fillRandom(1, 10, random);

        System.out.println("Матриця 1:");
        matrix1.display();

        System.out.println("\nМатриця 2:");
        matrix2.display();

        // Додавання
        System.out.println("\nДодавання:");
        Matrix<Double> sum = matrix1.add(matrix2);
        sum.display();

        // Віднімання
        System.out.println("\nВіднімання:");
        Matrix<Double> difference = matrix1.subtract(matrix2);
        difference.display();

        // Множення
        System.out.println("\nМноження:");
        Matrix<Double> product = matrix1.multiply(matrix2);
        product.display();

        // Ділення
        System.out.println("\nДілення:");
        Matrix<Double> division = matrix1.divide(matrix2);
        division.display();

        // Максимум
        System.out.println(
                "\nМаксимальний елемент: "
                        + matrix1.max()
        );

        // Мінімум
        System.out.println(
                "Мінімальний елемент: "
                        + matrix1.min()
        );

        // Середнє
        System.out.println(
                "Середнє арифметичне: "
                        + matrix1.average()
        );
    }
}