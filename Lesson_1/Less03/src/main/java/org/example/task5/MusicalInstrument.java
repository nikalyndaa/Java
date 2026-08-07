package org.example.task5;

public class MusicalInstrument {
    private String name;
    private String description;

    public MusicalInstrument(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void Sound() {
        System.out.println("Instrument sound");
    }

    public void Show() {
        System.out.println("Instrument: " + name);
    }

    public void Desc() {
        System.out.println(description);
    }

    public void History() {
        System.out.println("History of the instrument.");
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
