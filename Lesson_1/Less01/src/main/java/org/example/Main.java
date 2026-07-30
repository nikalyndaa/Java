package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // task1

//        System.out.println("\"Your time is limited, \n\tso don’t waste it" +
//                "\n\t\tliving someone else’s life\" \n\t\t\tSteve Jobs");


        //task2
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Введіть значення: ");
//        int num = scanner.nextInt();
//        System.out.print("Введіть відсоток: ");
//        int rate = scanner.nextInt();
//
//        System.out.println( rate + " % від " + num);
//        int res = num * rate / 100;
//        System.out.print("Результат: " + res);

        //task3
//        Scanner scanner = new Scanner(System.in);
//        int numRes = 0;
//        System.out.println("Введіть 3 числа (від 0 до 9):: ");
//        for (int i = 0; i < 3; i++) {
//            System.out.print("Введіть " + (i+1) + " значення: ");
//            int num = scanner.nextInt();
//
//            numRes = numRes * 10 + num;
//        }
//        System.out.println("Сформоване число: "+ numRes);



        //task4
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter six-digit number (0-9): ");
//        int number = scanner.nextInt(); //123456
//
//        while (true) {
//            if (String.valueOf(number).length() == 6) {
//                break;
//            }
//            System.out.println("Помилка! Число повинно мати рівно 6 цифр.");
//            System.out.print("--- Наступна спроба --- \nВведіть число знову: ");
//
//            number = scanner.nextInt();
//        }
//
//
//        int b1 = number / 100000; //1 23456
//        int b2 = (number / 10000) % 10; // 12 2
//        int b3 = (number / 1000)  %10; // 123 3
//        int b4 = (number / 100) %10; // 1234 4
//        int b5 = (number / 10) %10;
//        int b6 = number % 10 ;
////        System.out.println(b1);
////        System.out.println(b2);
////        System.out.println(b3);
////        System.out.println(b4);
////        System.out.println(b5);
////        System.out.println(b6);
//
//        int res = b6 * 1000000 + b5 * 100000 + b3 * 10000 + b4 * 1000 + b2 * 100 + b1 *10;
//
//        System.out.println("Результат перетворення: "+ res);


        //task5
//        System.out.println("Введіть номер місяця (1-12): ");
//        Scanner scan = new Scanner(System.in);
//        byte month = scan.nextByte();
//
//        switch (month){
//            case 1:
//            case 2:
//            case 12:
//                System.out.println("Winter");
//                break;
//            case 3:
//            case 4:
//            case 5:
//                System.out.println("Spring");
//                break;
//            case 6:
//            case 7:
//            case 8:
//                System.out.println("Summer");
//                break;
//            case 9:
//            case 10:
//            case 11:
//                System.out.println("Autumn");
//                break;
//            default:
//                System.out.println("Error! Number must be in (1-12)");
//                break;
//        }


        //task6
//        System.out.println("Введіть кількість метрів: ");
//        Scanner scan = new Scanner(System.in);
//        int m = scan.nextInt();
//        System.out.println("---Меню перетворень---");
//        System.out.print("1 - милі \n2 - дюйми \n3 - ярди \n\nВиберіть пункт : ");
//        byte menu = scan.nextByte();
//        float res = 0.0f;
//        if(menu== 1){
//            res = m * 0.00062137f;
//        }
//        else if(menu==2){
//            res = m * 39.37f;
//        }
//        else if(menu==3){
//            res = m * 1.0963f;
//        }
//        else{
//            System.out.println("Неправильне число");
//        }
//
//        System.out.println("Результат перетворення: "+ res);


          //task7
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Введіть перше число: ");
//        int num1 = scan.nextInt();
//        System.out.println("Введіть друге число: ");
//        int num2 = scan.nextInt();
//
//        int start = Math.min(num1,num2);
//        int end = Math.max(num1,num2);
//
//        for (int i = start; i<=end; i++){
//            if(i % 2 !=0){
//                System.out.print(i + " ");
//            }
//        }
//        System.out.println();



        //task8
//        Scanner scan = new Scanner(System.in);
//
//        System.out.println("Enter 1 num: ");
//        int num1 = scan.nextInt();
//        System.out.println("Enter 2 num: ");
//        int num2 = scan.nextInt();
//
//        int start = Math.min(num1,num2);
//        int end = Math.max(num1,num2);
//
//        for(int i = start; i <=end; i++){
//            System.out.println("Таблиця множення для числа " + i + ":");
//
//            for(int j =1;j<=10;j++){
//                System.out.println(i + " * " + j + " = " + (i * j));
//            }
//
//            System.out.println();
//        }

        //task9
//        Scanner scan = new Scanner(System.in);
//        System.out.print("Enter 1 num: ");
//        int num1 = scan.nextInt();
//        System.out.print("Enter 2 num: ");
//        int num2 = scan.nextInt();
//        System.out.print("Enter size: ");
//        int size = scan.nextInt();
//
//
//        int start = Math.min(num1, num2);
//        int end = Math.max(num1, num2);
//
//        int[] array = new int[size];
//
//        Random rand = new Random();
//
//        for(int i =0; i<array.length; i++){
//            array[i] = rand.nextInt(end-start +1) + start;
//        }
//
//        System.out.print("Заповнений масив: ");
//        for(int item: array){
//            System.out.print(item + " ");
//        }
//        System.out.println();
//
//        int min = array[0];
//        for (int item : array){
//            if(item < min){
//                min = item;
//            }
//        }
//        System.out.println("Мінімальне значення: " + min);
//
//        int max = array[0];
//        for (int item : array){
//            if(item > max){
//                max = item;
//            }
//        }
//        System.out.println("Максимальне значення: " + max);
//
//        int countMinus = 0;
//        for (int item : array){
//            if(item < 0){
//                countMinus++;
//            }
//        }
//        System.out.println("Кількість відємних значень: " + countMinus);
//
//        int countPlus = 0;
//        for (int item : array){
//            if(item > 0){
//                countPlus++;
//            }
//        }
//        System.out.println("Кількість додатніх значень: " + countPlus);
//
//
//        int countZero = 0;
//        for (int item : array){
//            if(item == 0){
//                countZero++;
//            }
//        }
//        System.out.println("Кількість нулів: " + countZero);


        //task10
//        int size = 15;
//        int[] originArray = new int[size];
//        Random rand = new Random();
//
//        for (int i = 0; i < originArray.length; i++) {
//            originArray[i] = rand.nextInt(101) - 50;
//        }
//
//        System.out.print("Початковий масив:");
//        for(int item: originArray){
//            System.out.print(item + " ");
//        }
//        System.out.println();
//
//        // розмір кодного масиву
//        int evenCount = 0;
//        int oddCount = 0;
//        int negativeCount = 0;
//        int positiveCount = 0;
//
//        for(int item: originArray){
//            if(item % 2 ==0)
//                evenCount++;
//            else oddCount++;
//
//            if(item>0) positiveCount++;
//            else if (item < 0) negativeCount++;
//        }
//
//        // створення нових масивів
//        int[] evenArray = new int[evenCount];
//        int[] oddArray = new int[oddCount];
//        int[] positiveArray = new int[positiveCount];
//        int[] negativeArray = new int[negativeCount];
//
//        //індекси
//        int evenId = 0, oddId = 0, negativeId=0, positiveId=0;
//
//        for(int item: originArray){
//            if(item % 2 ==0 ) evenArray[evenId++] = item;
//            else oddArray[oddId++] = item;
//
//            if(item<0) negativeArray[negativeId++] = item;
//            else if (item > 0) positiveArray[positiveId++]= item;
//        }
//
//        System.out.print("Масив парних чисел: ");
//        for (int item : evenArray){
//            System.out.print(item + " ");
//        }
//        System.out.println();
//
//        System.out.print("Масив непарних чисел: ");
//        for (int item : oddArray){
//            System.out.print(item + " ");
//        }
//        System.out.println();
//
//        System.out.print("Масив відємних чисел: ");
//        for (int item : negativeArray){
//            System.out.print(item + " ");
//        }
//        System.out.println();
//
//        System.out.print("Масив додатніх чисел: ");
//        for (int item : positiveArray){
//            System.out.print(item + " ");
//        }


        //task11
//        System.out.print("Введіть символ лінії: ");
//        Scanner scan = new Scanner(System.in);
//        String symbol = scan.nextLine();
//        System.out.print("Введіть напрямок лінії (v / h): ");
//        String direction = scan.nextLine();
//        System.out.print("Введіть довжину лінії: ");
//        int size = scan.nextInt();
//
//        myMethod(symbol,direction,size);


        //task12
        int[] myArray = {5, 2, 9, 1, 6, 3};

        System.out.println("Масив до сортування: " + Arrays.toString(myArray));

        // Виклик вашого методу
        myMethod(myArray);

        System.out.println("Масив після сортування: " + Arrays.toString(myArray));
    }
    //task11
    public static void myMethod(String sym, String direction, int size){


       if(direction.equalsIgnoreCase("h")){
           for (int i = 0; i < size; i++) {
               System.out.print(sym);
           }
           System.out.println();
       }
       else if(direction.equalsIgnoreCase("v")){
            for (int i = 0; i < size; i++) {
                System.out.println(sym);
            }
            System.out.println();
       }
       else {
           System.out.println("Помилка! Невідомий напрямок: " + direction);
       }
    }


    //task12
    public static void myMethod (int[] array){
        System.out.println("Менб");
        System.out.println("Сортування в порядку: \n1-Зростання \n2-Спадання");
        System.out.println("Ваш вибір: ");
        Scanner scan = new Scanner(System.in);

        int choice = scan.nextInt();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                boolean needSwap = false;

                if (choice == 1) {
                    if(array[j] > array[j+1])
                        needSwap = true;}
                else if (choice == 2) {
                    if (array[j] < array[j + 1]) {
                        needSwap = true;
                    }
                }

                if(needSwap){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }

            }
        }

            if (choice != 1 && choice != 2) {
                System.out.println("Помилка! Неправильний вибір меню. Масив залишено без змін.");
            }
    }

}