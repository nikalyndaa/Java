package org.example.task4;

public class Device {
    private String name;
    private String description;

    public Device(String name, String description){
        this.name = name;
        this.description = description;
    }

    public void Sound() {
        System.out.println("Device sound");
    }

    public void Show() {
        System.out.println("Device: " + name);
    }

    public void Desc() {
        System.out.println("Description: " + description);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
