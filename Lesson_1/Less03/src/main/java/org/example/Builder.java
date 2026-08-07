package org.example;

import java.util.Scanner;

public class Builder extends Human  {

    private String job;
    private int experience;
    private String buildingCompany;


    public Builder(String firstName, String lastName, int age, String city,
                   String job, int experience, String buildingCompany) {
        super(firstName, lastName, age, city);
        this.job = job;
        this.experience = experience;
        this.buildingCompany = buildingCompany;

    }

    public String IamBuilder(){
        return "Hello, I am a builder";
    }

    private final Scanner scan = new Scanner(System.in);

    @Override
    public void inputData() {
        super.inputData();

        this.job = scan.nextLine();
        this.experience = scan.nextInt();
        this.buildingCompany = scan.nextLine();

    }

    @Override
    public String outputData(){
         return super.outputData() +
                 "\nProfession: " + job +
                 "\nExperience: " + experience +
                 "\nBuilding company: " + buildingCompany;
    }

    public int getExperience() {
        return experience;
    }

    public String getBuildingCompany() {
        return buildingCompany;
    }

    public void setBuildingCompany(String buildingCompany) {
        this.buildingCompany = buildingCompany;
    }

    public String getJob() {
        return job;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setJob(String job) {
        this.job = job;
    }


}
