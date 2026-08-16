package org.example;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Supplier;


public class Array<T extends  Number & Comparable<T>> {
    private T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public Array(int size){
        if (size <= 0) {
            throw new IllegalArgumentException("Розмір масиву повинен бути додатнім");
        }
        this.size = size;
        this.data = (T[]) new Number[size];
    }

    public int getSize(){
        return size;
    }

    public T get(int index){
        checkIndex(index);
        return data[index];
    }

    public void set(int index, T value) {
        checkIndex(index);
        data[index] = value;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Індекс поза межами масиву: " + index);
        }
    }

    public void fillArray(Function<String, T> parser){
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть " + size + "  елементи масиву: ");

        for (int i = 0; i < size; i++) {
            boolean success = false;

            while(!success){
                System.out.println("Елемент [" + i + "]: ");
                String line = scan.nextLine();
                try{
                    data[i] =parser.apply(line);
                    success = true;
                }catch (NumberFormatException e) {
                    System.out.println("Некоректне значення, спробуйте ще раз.");
                }
            }

        }
    }

    public void fillRandom(Supplier<T> generator) {
        for (int i = 0; i < size; i++) {
            data[i] = generator.get();
        }
    }

    public void print() {
        System.out.println(Arrays.toString(data));
    }

    public T max(){
        T max = data[0];

        for(T item:data){
            if(item.compareTo(max) > 0){
                max = item;
            }
        }
        return max;
    }

    public T min(){
        T min = data[0];

        for(T item:data){
            if(item.compareTo(min) < 0){
                min = item;
            }
        }
        return min;
    }

    public double average(){
        double sum = 0;

        for(T item: data){
            sum += item.doubleValue();
        }

        return sum / data.length;
    }

    public void sortAscending(){
         Arrays.sort(data);
    }

    public void sortDescending(){
        Arrays.sort(data, (a,b) -> b.compareTo(a));
    }

    public int binarySearch(T value){
        sortAscending();

        int left = 0;
        int right = data.length - 1;

        while(left <= right){
            int middle = (left + right)/2;

            int comparison = data[middle].compareTo(value);

            if (comparison ==0){
                return middle;
            }
            if(comparison < 0){
                left = middle + 1;
            }else{
                right = middle - 1;
            }

        }
        return -1;
    }

     public boolean replace(T oldValue, T newValue){
         for (int i = 0; i < data.length; i++) {
             if(data[i].compareTo(oldValue)==0){
                 data[i] = newValue;
                 return true;
             }
         }
         return false;
     }

     public T[] getData(){
        return data;
     }


}
