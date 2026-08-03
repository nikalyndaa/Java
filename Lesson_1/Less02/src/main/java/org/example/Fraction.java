package org.example;

public class Fraction {
    private int numerator;     // чисельник
    private int denominator;   // знаменник

    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменник не може дорівнювати 0!");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction add(Fraction other) {
        return new Fraction(
                numerator * other.denominator + other.numerator * denominator,
                denominator * other.denominator
        );
    }

    public Fraction subtract(Fraction other) {
        return new Fraction(
                numerator * other.denominator - other.numerator * denominator,
                denominator * other.denominator
        );
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
