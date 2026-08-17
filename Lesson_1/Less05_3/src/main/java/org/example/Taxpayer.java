package org.example;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Taxpayer {
    private final String idCode;
    private String name;
    private String city;
    private final List<Fine> fines;

    public Taxpayer(String idCode, String name, String city, List<Fine> initialFines) {
        this.idCode = idCode;
        this.name = name;
        this.city = city;
        this.fines = new ArrayList<>(initialFines != null ? initialFines : Collections.emptyList());
    }

    public String getIdCode() {
        return idCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Fine> getFines() {
        return fines;
    }

    public void addFine(Fine fine) {
        this.fines.add(fine);
    }

    public boolean removeFine(int index) {
        if (index >= 0 && index < fines.size()) {
            fines.remove(index);
            return true;
        }
        return false;
    }

    public void printInfo() {
        System.out.println("ІПН: " + idCode + " | ПІБ: " + name + " | Місто: " + city);
        if (fines.isEmpty()) {
            System.out.println("   Штрафи відсутні.");
        } else {
            System.out.println("   Штрафи:");
            for (int i = 0; i < fines.size(); i++) {
                System.out.println("     [" + (i + 1) + "] " + fines.get(i));
            }
        }
    }
}