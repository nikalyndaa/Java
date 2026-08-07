package org.example;

import java.util.Scanner;

public class Pilot extends Human{
    private String aircraftType;
    private String airline;
    private String licenseCategory;

    public Pilot(String firstName, String lastName, int age, String city,
                 String aircraftType, String airline, String licenseCategory) {
        super(firstName, lastName, age, city);

        this.aircraftType = aircraftType;
        this.airline = airline;
        this.licenseCategory = licenseCategory;
    }

    public String IamPilot(){
        return "Hello, I am a pilot";
    }

    private final Scanner scan = new Scanner(System.in);

    @Override
    public void inputData() {
        super.inputData();
        String aircraftType = scan.nextLine();
        String airline = scan.nextLine();
        String licenseCategory = scan.nextLine();
    }

    @Override
    public String outputData() {
        return super.outputData() +
                "\naircraft type: " + aircraftType +
                "\nAirline: " + airline +
                "\nLicense category: " + licenseCategory;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public String getAirline() {
        return airline;
    }

    public String getLicenseCategory() {
        return licenseCategory;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public void setLicenseCategory(String licenseCategory) {
        this.licenseCategory = licenseCategory;
    }
}
