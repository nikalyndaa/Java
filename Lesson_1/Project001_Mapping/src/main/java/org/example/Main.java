package org.example;

import org.example.seed.DatabaseSeeder;
import org.example.utils.HibernateHelper;

public class Main {
    public static void main(String[] args) {
        try {
            DatabaseSeeder.seed();

            // Закриваємо фабрику при завершенні програми
            HibernateHelper.shutDown();

        }catch (Exception e) {
            System.out.println("Щось пішло не так"+e.getMessage());
        }
    }
}