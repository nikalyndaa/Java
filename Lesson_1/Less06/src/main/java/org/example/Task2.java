package org.example;

import java.util.function.BiFunction;

public class Task2 {
    public static class Fraction{
        private int a; //чисельник
        private int b; // знаменник

        public Fraction(int a, int b) {
            if (b == 0) {
                throw new IllegalArgumentException("Знаменник не може бути нулем");
            }
            this.a = a;
            this.b = b;
        }

        public String toString(){
            return a  + "/" + b;
        }

        public void lambdaRun(){
            BiFunction<Fraction, Fraction, Fraction> add = (f1,f2) -> new Fraction(f1.a * f2.b + f2.a * f1.b ,f1.a * f2.b);
            BiFunction<Fraction, Fraction, Fraction> sub = (f1,f2) -> new Fraction(f1.a * f2.b - f2.a * f1.b ,f1.a * f2.b);
            BiFunction<Fraction, Fraction, Fraction> mul = (f1,f2) -> new Fraction(f1.a *f2.a, f1.b * f2.b);
            BiFunction<Fraction, Fraction, Fraction> div = (f1,f2) -> {
                if (f1.b == 0 || f2.b == 0 || f2.a == 0) {
                    throw new ArithmeticException("Спроба ділення на 0 або некоректний дріб");
                }
                return new Fraction(f1.a * f2.b, f1.b * f2.a);
            };

            System.out.println(add.apply(new Fraction(1,2), new Fraction(1,2)));
            System.out.println(sub.apply(new Fraction(2,7), new Fraction(1,2)));
            System.out.println(mul.apply(new Fraction(8,9), new Fraction(4,6)));
            System.out.println(div.apply(new Fraction(1,2), new Fraction(1,2)));

        }
    }

}
