package org.example.task5;

public class Cello extends MusicalInstrument {

    private String material;
    private double height;

    public Cello(String name, String description,
                 String material, double height) {
        super(name, description);
        this.material = material;
        this.height = height;
    }

    @Override
    public void Sound() {
        System.out.println("Cello: Voooo...");
    }

    @Override
    public void Show() {
        System.out.println("Name: " + getName());
    }

    @Override
    public void Desc() {
        System.out.println(getDescription());
        System.out.println("Material: " + material);
        System.out.println("Height: " + height + " cm");
    }

    @Override
    public void History() {
        System.out.println("The cello was created in Italy in the 16th century.");
    }
}
