package org.example;
import java.util.*;
import java.util.stream.Collectors;

public class TaxInspectionDatabase {
    private final Map<String, Taxpayer> database = new LinkedHashMap<>();

    public TaxInspectionDatabase() {
        seedInitialData();
    }

    private void seedInitialData() {
        Taxpayer p1 = new Taxpayer("1234567890", "Іваненко Іван Іванович", "Київ", List.of(
                new Fine("Перевищення швидкості", 340.00),
                new Fine("Несплата податку", 1500.00)
        ));

        Taxpayer p2 = new Taxpayer("0987654321", "Петренко Петро Петрович", "Львів", List.of(
                new Fine("Паркування у невстановленому місці", 680.00)
        ));

        Taxpayer p3 = new Taxpayer("1122334455", "Сидоренко Олена Сергіївна", "Київ", List.of(
                new Fine("Перевищення швидкості", 340.00),
                new Fine("Проїзд на червоне світло", 510.00)
        ));

        addTaxpayer(p1);
        addTaxpayer(p2);
        addTaxpayer(p3);
    }

    public boolean addTaxpayer(Taxpayer taxpayer) {
        if (database.containsKey(taxpayer.getIdCode())) {
            return false;
        }
        database.put(taxpayer.getIdCode(), taxpayer);
        return true;
    }

    public Taxpayer getByCode(String code) {
        return database.get(code);
    }

    public Collection<Taxpayer> getAll() {
        return database.values();
    }

    public List<Taxpayer> getByCity(String city) {
        return database.values().stream()
                .filter(p -> p.getCity().equalsIgnoreCase(city))
                .toList();
    }

    public Map<Taxpayer, List<Fine>> getByFineType(String fineType) {
        Map<Taxpayer, List<Fine>> result = new LinkedHashMap<>();
        String lowerType = fineType.toLowerCase();

        for (Taxpayer p : database.values()) {
            List<Fine> matching = p.getFines().stream()
                    .filter(f -> f.getType().toLowerCase().contains(lowerType))
                    .collect(Collectors.toList());

            if (!matching.isEmpty()) {
                result.put(p, matching);
            }
        }
        return result;
    }

    public boolean isEmpty() {
        return database.isEmpty();
    }
}