package org.example.task5;

public class Trombone extends  MusicalInstrument{

    private String material;
    private String type;

    public Trombone(String name, String description,
                    String material, String type) {
        super(name, description);
        this.material = material;
        this.type = type;
    }

    @Override
    public void Sound() {
        System.out.println("Trombone: Pooo...");
    }

    @Override
    public void Show() {
        System.out.println("Name: " + getName());
    }

    @Override
    public void Desc() {
        System.out.println(getDescription());
        System.out.println("Material: " + material);
        System.out.println("Type: " + type);
    }

    @Override
    public void History() {
        System.out.println("The trombone has been known since the 15th century.");
    }
}
