package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Введіть розмір масиву: ");
        int n = Integer.parseInt(scanner.nextLine());

        Array<Integer> array = new Array<>(n);

        // --- Оберіть спосіб заповнення масиву ---
        System.out.println("Як заповнити масив?");
        System.out.println("1 - вручну з клавіатури");
        System.out.println("2 - випадковими числами");
        System.out.print("Ваш вибір: ");
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            array.fillArray(Integer::parseInt);
        } else {
            array.fillRandom(() -> random.nextInt(100)); // числа від 0 до 99
        }
        System.out.println("\nВихідний масив:");
        array.print();
        // Максимум
        System.out.println("Максимум: " + array.max());
        // Мінімум
        System.out.println("Мінімум: " + array.min());
        // Середнє
        System.out.println("Середнє: " + array.average());
        // Сортування по зростанню
        array.sortAscending();
        System.out.println("По зростанню:");
        array.print();
        // Сортування по спаданню
        array.sortDescending();
        System.out.println("По спаданню:");
        array.print();
        // Бінарний пошук
        int index = array.binarySearch(50);
        System.out.println("Індекс числа 50: " + index);

        // Заміна значення
        boolean replaced = array.replace(50, 999);

        if (replaced) {
            System.out.println("Значення замінено:");
        } else {
            System.out.println("Значення не знайдено.");
        }

        array.print();
    }
}