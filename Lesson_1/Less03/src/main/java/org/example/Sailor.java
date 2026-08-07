package org.example;

import java.util.Scanner;

public class Sailor extends  Human{

    private String shipName;
    private String positionShip;
    private String typeShip;

    public Sailor(String firstName, String lastName, int age, String city,
                  String shipName, String positionShip, String typeShip) {
        super(firstName, lastName, age, city);

        this.shipName = shipName;
        this.positionShip = positionShip;
        this.typeShip = typeShip;
    }

    public String IamSailor(){
        return "Hello, I am a sailor";
    }

    private final Scanner scan = new Scanner(System.in);

    @Override
    public void inputData() {
        super.inputData();
        this.shipName = scan.nextLine();
        this.positionShip = scan.nextLine();
        this.typeShip = scan.nextLine();
    }

    @Override
    public String outputData() {
        return super.outputData() +
                "\nShip name: " + shipName +
                "\nPosition on the ship: " + positionShip +
                "\nType of ship: " + typeShip;
    }

    public void setShipName(String shipName){
        this.shipName = shipName;
    }
    public void positionShip(String positionShip){
        this.positionShip = positionShip;
    }
    public void typeShip(String typeShip){
        this.typeShip = typeShip;
    }

    public String getShipName(){
        return  shipName;
    }

    public String getPositionShip() {
        return positionShip;
    }

    public String getTypeShip() {
        return typeShip;
    }
}
