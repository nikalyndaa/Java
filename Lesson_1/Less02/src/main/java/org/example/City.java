package org.example;

public class City {
    private String name;
    private int population;

    public City(String name, int population){
        this.name = name;
        this.population = population;
    }

    public City(){
        this("None", 0);
    }

    public City(City other) {
        if (other != null) {
            this.name = other.name;
            this.population = other.population;
        }
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
       return "City{name='" + name + "', population=" + population + "}";
     }
}
