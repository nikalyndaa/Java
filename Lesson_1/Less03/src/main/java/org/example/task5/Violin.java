package org.example.task5;

public class Violin extends MusicalInstrument{
    private String material;
    private int strings;


    public Violin(String name, String description,
                  String material, int strings) {
        super(name, description);
        this.material = material;
        this.strings = strings;
    }

    @Override
    public void Sound() {
        System.out.println("так звучить віолончель");
    }

    @Override
    public void Show() {
        System.out.println("Name: " + getName());
    }

    @Override
    public void Desc() {
        System.out.println("Desc: " + getDescription());
        System.out.println("Material: " + material);
        System.out.println("Strings: " + strings);
    }

    @Override
    public void History() {
        System.out.println("History of violin" );
    }
}
