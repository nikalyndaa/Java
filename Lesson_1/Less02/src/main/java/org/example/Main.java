package org.example;


public class Main {
    public static void main(String[] args) {

        //task1
//
//        Person personObj1 = new Person();
//        Person personObj2 = new Person("Ivan",22);
//        Person personObj3 = new Person("Davyd",52);
//
//        System.out.println(personObj1);
//        System.out.println(personObj2);
//        System.out.println(personObj3);
//
//        int ageComparison = personObj2.compareTo(personObj3);
//        if (ageComparison >0) {
//            System.out.println(personObj2.getName() + " older than " + personObj3.getName()) ;
//
//        }
//        else if (ageComparison < 0) {
//            System.out.println(personObj2.getName() + " younger than " + personObj3.getName()) ;
//
//        }
//        else
//            System.out.println("Equal age");



        //task2
//        City cityObj1 = new City();
//        City cityObj2 = new City("Lviv", 20000);
//        City cityObj3 = new City("Ternopil", 10000);
//
//        City cityObj4 = new City(cityObj2);
//
//        System.out.println(cityObj1);
//        System.out.println(cityObj2);
//        System.out.println(cityObj3);
//
//        System.out.println(cityObj4);
//
//        cityObj3.setName("Kyiv");
//        System.out.println(cityObj3);



//        //task3
//        Country country = new Country("Україна", 603628.0);
//        country.addCity("Одеса", 1010000);
//        country.addCity("Харків", 1400000);
//
//        System.out.println(country);
//
//        for(City city : country.getCities()){
//            System.out.println(" - " + city.getName() + " (населення: " + city.getPopulation() + ")");
//        }


        //task4

//        Fraction a = new Fraction(1,2);
//        Fraction b = new Fraction(5,4);
//
//        System.out.println("a = " + a);
//        System.out.println("b = " + b);
//
//        System.out.println("a + b = " + a.add(b));
//        System.out.println("a - b = " + a.subtract(b));


        //task5
//        Book book = new Book();
//        book.inputData();
//        book.printInfo();

        //task6
        Car car = new Car();
        Car car2 = new Car();
        car2.inputData("BMW", "Germany", 2021, 2.0);
        car.inputData();
        System.out.println(car);
        System.out.println();
        System.out.println(car2.getManufacture());




    }
}