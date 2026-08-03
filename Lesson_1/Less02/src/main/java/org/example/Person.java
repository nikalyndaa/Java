package org.example;

import java.util.Objects;

public class Person implements Comparable<Person>{

    /*
    До вже реалізованого класу “Людина” додати необхідні
    конструктори, а також необхідні перевантажені
    методи
     */

    private String name;
    private int age;

    public Person () {
        this("None", 0);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }

    @Override
    public int compareTo(Person other){
        return Integer.compare(this.age,other.age);
    }




}
