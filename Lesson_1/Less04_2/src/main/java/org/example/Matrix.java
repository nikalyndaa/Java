package org.example;

import java.util.Random;
import java.util.Scanner;
import java.util.function.DoubleFunction;

public class Matrix<T extends  Number> {
    private final int rows;
    private final int cols;
    private final T[][] data;
    private final DoubleFunction<T> converter;

    @SuppressWarnings("unchecked")
    public Matrix(int rows, int cols, DoubleFunction<T> converter) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Розмірність матриці має бути додатною");
        }
        this.rows = rows;
        this.cols = cols;
        this.converter = converter;
        this.data = (T[][]) new Number[rows][cols];
        // ініціалізація нулями
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = converter.apply(0.0);
            }
        }
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }

    public T get(int i, int j) { return data[i][j]; }
    public void set(int i, int j, T value) { data[i][j] = value; }

    public void fillFromKeyboard(Scanner scanner) {
        System.out.println("Введіть елементи матриці " + rows + "x" + cols + " (через Enter):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("Елемент [%d][%d] = ", i, j);
                double value = scanner.nextDouble();
                data[i][j] = converter.apply(value);
            }
        }
    }

    public void fillRandom(double min, double max, Random random) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double value = min + random.nextDouble() * (max - min);
                data[i][j] = converter.apply(value);
            }
        }
    }

    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.printf("%8.2f ", data[i][j].doubleValue());
            }
            System.out.println();
        }
    }

    private double[][] toDoubleArray() {
        double[][] result = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = data[i][j].doubleValue();
            }
        }
        return result;
    }

    private Matrix<T> fromDoubleArray(double[][] src) {
        Matrix<T> result = new Matrix<>(src.length, src[0].length, converter);
        for (int i = 0; i < src.length; i++) {
            for (int j = 0; j < src[0].length; j++) {
                result.data[i][j] = converter.apply(src[i][j]);
            }
        }
        return result;
    }

    private void checkSameSize(Matrix<T> other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Розмірності матриць не збігаються");
        }
    }

    public Matrix<T> add(Matrix<T> other){
        checkSameSize(other);

        double[][] result  = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = data[i][j].doubleValue() + other.data[i][j].doubleValue();

            }
        }

        return fromDoubleArray(result);
    }

    public Matrix<T> subtract(Matrix<T> other){
        checkSameSize(other);

        double[][] result  = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = data[i][j].doubleValue() - other.data[i][j].doubleValue();

            }
        }

        return fromDoubleArray(result);
    }

    public Matrix<T> multiply(Matrix<T> other){
        if (this.cols != other.rows) {

            throw new IllegalArgumentException(
                    "Кількість стовпців першої матриці "
                            + "повинна дорівнювати кількості "
                            + "рядків другої матриці"
            );
        }
        double[][] result =
                new double[this.rows][other.cols];

        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                double sum = 0;

                for (int k = 0; k < this.cols; k++) {

                    sum +=
                            this.data[i][k].doubleValue()
                                    * other.data[k][j].doubleValue();
                }

                result[i][j] = sum;
            }
        }

        return fromDoubleArray(result);
    }


    public Matrix<T> divide(Matrix<T> other) {

        checkSameSize(other);

        double[][] result =
                new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double divisor =
                        other.data[i][j].doubleValue();
                if (divisor == 0) {

                    throw new ArithmeticException(
                            "Ділення на нуль неможливе!"
                    );
                }
                result[i][j] =
                        data[i][j].doubleValue()
                                / divisor;
            }
        }

        return fromDoubleArray(result);
    }

    public T max(){
        T max = data[0][0];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(data[i][j].doubleValue() > max.doubleValue()){
                    max = data[i][j];
                }
            }
        }
        return max;
    }

    public T min(){
        T min = data[0][0];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(data[i][j].doubleValue() < min.doubleValue()){
                    min = data[i][j];
                }
            }
        }
        return min;
    }

    public double average(){
        double sum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += data[i][j].doubleValue();
            }
        }
        return sum / data.length;
    }
}
