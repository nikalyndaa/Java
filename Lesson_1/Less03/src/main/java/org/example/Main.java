package org.example;

import org.example.task2.Crocodile;
import org.example.task2.Kangaroo;
import org.example.task2.Tiger;
import org.example.task3.Product;
import org.example.task4.Car;
import org.example.task4.Kettle;
import org.example.task4.Microwave;
import org.example.task4.Steamship;
import org.example.task5.Cello;
import org.example.task5.Trombone;
import org.example.task5.Ukulele;
import org.example.task5.Violin;
import org.example.task6.Array;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//task1
//        Builder builder = new Builder(
//                "Ivan",
//                "Petrenko",
//                35,
//                "Lviv",
//                "Bricklayer",
//                10,
//                "BudMax"
//        );
//
//        Sailor sailor = new Sailor(
//                "Oleksandr",
//                "Koval",
//                40,
//                "Odesa",
//                "Black Pearl",
//                "Captain",
//                "Cargo ship"
//        );
//
//        Pilot pilot = new Pilot(
//                "Andrii",
//                "Shevchenko",
//                32,
//                "Kyiv",
//                "Boeing 737",
//                "SkyUp",
//                "Category A"
//        );
//
//        System.out.println(builder.IamBuilder());
//        System.out.println(builder.outputData());
//
//        System.out.println();
//
//        System.out.println(sailor.IamSailor());
//        System.out.println(sailor.outputData());
//
//        System.out.println();
//
//        System.out.println(pilot.IamPilot());
//        System.out.println(pilot.outputData());

    //task2
//        Tiger tiger = new Tiger(
//                "Sher Khan",
//                7,
//                "Orange",
//                210,
//                "Black",
//                "Jungle",
//                65
//        );
//
//        Crocodile crocodile = new Crocodile(
//                "Croc",
//                18,
//                "Green",
//                450,
//                "Nile",
//                5.2,
//                66
//        );
//
//        Kangaroo kangaroo = new Kangaroo(
//                "Jack",
//                4,
//                "Brown",
//                80,
//                8.5,
//                "Australia",
//                true
//        );
//
//        System.out.println(tiger.IamTiger());
//        System.out.println(tiger.outputData());
//
//        System.out.println();
//
//        System.out.println(crocodile.IamCrocodile());
//        System.out.println(crocodile.outputData());
//
//        System.out.println();
//
//        System.out.println(kangaroo.IamKangaroo());
//        System.out.println(kangaroo.outputData());


        //task3
//        Product product = new Product(
//                "Laptop",
//                25000,
//                75
//        );
//
//        System.out.println("Before discount:");
//        System.out.println(product.outputData());
//
//        product.discount(1500, 50);
//
//        System.out.println();
//        System.out.println("After discount:");
//        System.out.println(product.outputData());


        //task4
//        Kettle kettle = new Kettle(
//                "Bosch Kettle",
//                "Electric kettle",
//                2,
//                2200
//        );
//
//        Microwave microwave = new Microwave(
//                "Samsung Microwave",
//                "Kitchen microwave oven",
//                900,
//                25
//        );
//
//        Car car = new Car(
//                "BMW M5",
//                "Sports car",
//                "BMW",
//                305
//        );
//
//        Steamship steamship = new Steamship(
//                "Titanic",
//                "Passenger steamship",
//                2400,
//                269.1
//        );
//
//        System.out.println("=== Kettle ===");
//        kettle.Show();
//        kettle.Desc();
//        kettle.Sound();
//
//        System.out.println();
//
//        System.out.println("=== Microwave ===");
//        microwave.Show();
//        microwave.Desc();
//        microwave.Sound();
//
//        System.out.println();
//
//        System.out.println("=== Car ===");
//        car.Show();
//        car.Desc();
//        car.Sound();
//
//        System.out.println();
//
//        System.out.println("=== Steamship ===");
//        steamship.Show();
//        steamship.Desc();
//        steamship.Sound();




        //task5
//        Violin violin = new Violin(
//                "Stradivarius",
//                "String musical instrument",
//                "Wood",
//                4
//        );
//
//        Trombone trombone = new Trombone(
//                "Yamaha Trombone",
//                "Brass wind instrument",
//                "Brass",
//                "Tenor"
//        );
//
//        Ukulele ukulele = new Ukulele(
//                "Hawaiian Ukulele",
//                "Small string instrument",
//                4,
//                "Concert"
//        );
//
//        Cello cello = new Cello(
//                "Classic Cello",
//                "Large string instrument",
//                "Wood",
//                120
//        );
//
//        violin.Show();
//        violin.Desc();
//        violin.Sound();
//        violin.History();
//
//        System.out.println();
//
//        trombone.Show();
//        trombone.Desc();
//        trombone.Sound();
//        trombone.History();
//
//        System.out.println();
//
//        ukulele.Show();
//        ukulele.Desc();
//        ukulele.Sound();
//        ukulele.History();
//
//        System.out.println();
//
//        cello.Show();
//        cello.Desc();
//        cello.Sound();
//        cello.History();


        //task 6
        int[] numbers = {15, 8, 25, 3, 11, 40, 18};

        Array array = new Array(numbers);

        array.showArray();

        System.out.println("Maximum = " + array.Max());
        System.out.println("Minimum = " + array.Min());
        System.out.println("Average = " + array.Avg());

        //task7
        array.SortAsc();
        System.out.println("Масив після сортування по зрост: ");
        array.showArray();


        array.SortDesc();
        System.out.println("Масив після сортування по спад: ");
        array.showArray();

    }
}