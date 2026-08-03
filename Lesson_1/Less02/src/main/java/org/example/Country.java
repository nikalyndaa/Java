package org.example;

import java.util.ArrayList;
import java.util.List;

public class Country {
    private String name;
    private double area;
    private List<City> cities;

    public Country() {
        this("Невідомо", 0.0);
    }

    public Country(String name, double area) {
        this.name = name;
        this.area = area;
        this.cities = new ArrayList<>();
    }

    public void addCity(City city){
        if (city != null) {
            this.cities.add(city);
        }
    }

    public void addCity(String name, int population){
        this.cities.add(new City(name, population));
    }


    @Override
    public String toString() {
        return "Country{name='" + name + "', area=" + area + " km², citiesCount=" + cities.size() + "}";
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getArea() { return area; }
    public void setArea(double area) { this.area = area; }
    public List<City> getCities() { return cities; }
}
