package org.example.task5;

public class Ukulele extends MusicalInstrument {

    private int strings;
    private String size;

    public Ukulele(String name, String description,
                   int strings, String size) {
        super(name, description);
        this.strings = strings;
        this.size = size;
    }

    @Override
    public void Sound() {
        System.out.println("Ukulele: Pling...");
    }

    @Override
    public void Show() {
        System.out.println("Name: " + getName());
    }

    @Override
    public void Desc() {
        System.out.println(getDescription());
        System.out.println("Strings: " + strings);
        System.out.println("Size: " + size);
    }

    @Override
    public void History() {
        System.out.println("The ukulele originated in Hawaii in the 19th century.");
    }
}
