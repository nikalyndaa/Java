package org.example;
import java.util.*;

public class Main {
    private final TaxInspectionDatabase db = new TaxInspectionDatabase();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }

    public void run() {
        while (true) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> printAllDatabase();
                case "2" -> printByCode();
                case "3" -> printByFineType();
                case "4" -> printByCity();
                case "5" -> addPerson();
                case "6" -> addFineToPerson();
                case "7" -> removeFine();
                case "8" -> updatePersonOrFine();
                case "0" -> {
                    System.out.println("Завершення роботи системи.");
                    return;
                }
                default -> System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n=== БАЗА ДАНИХ ПОДАТКОВОЇ ІНСПЕКЦІЇ ===");
        System.out.println("1. Повний друк бази даних");
        System.out.println("2. Друк даних по конкретному коду (ІПН)");
        System.out.println("3. Друк даних по конкретному типу штрафу");
        System.out.println("4. Друк даних по конкретному місту");
        System.out.println("5. Додавання нової людини");
        System.out.println("6. Додавання нових штрафів для існуючого запису");
        System.out.println("7. Видалення штрафу");
        System.out.println("8. Заміна інформації про людину та її штрафи");
        System.out.println("0. Вихід");
        System.out.print("Оберіть пункт меню: ");
    }

    private void printAllDatabase() {
        System.out.println("\n--- ПОВНА БАЗА ДАНИХ ---");
        if (db.isEmpty()) {
            System.out.println("База даних порожня.");
            return;
        }
        db.getAll().forEach(p->{
            p.printInfo();
            System.out.println("----------------------------------------");

        });
    }

    private void printByCode() {
        System.out.print("Введіть ідентифікаційний код (ІПН): ");
        String code = scanner.nextLine().trim();

        Taxpayer taxpayer = db.getByCode(code);
        if (taxpayer != null) {
            System.out.println("\n--- РЕЗУЛЬТАТ ПОШУКУ ЗА ІПН ---");
            taxpayer.printInfo();
        } else {
            System.out.println("Запис з таким ІПН не знайдено.");
        }
    }

    private void printByFineType() {
        System.out.print("Введіть тип штрафу для пошуку: ");
        String type = scanner.nextLine().trim();

        var matches = db.getByFineType(type);
        System.out.println("\n--- ЛЮДИ ТА ШТРАФИ З ТИПОМ: " + type + " ---");

        if (matches.isEmpty()) {
            System.out.println("Записів з таким типом штрафу не знайдено.");
        } else {
            matches.forEach((p, fines) -> {
                System.out.println("ІПН: " + p.getIdCode() + " | ПІБ: " + p.getName() + " | Місто: " + p.getCity());
                fines.forEach(f -> System.out.println("   -> " + f));
            });
        }
    }

    private void printByCity() {
        System.out.print("Введіть місто для пошуку: ");
        String city = scanner.nextLine().trim();

        List<Taxpayer> results = db.getByCity(city);
        System.out.println("\n--- ПЛАТНИКИ З МІСТА: " + city + " ---");

        if (results.isEmpty()) {
            System.out.println("Людей із зазначеного міста не знайдено.");
        } else {
            results.forEach(p -> {
                p.printInfo();
                System.out.println("----------------------------------------");
            });
        }
    }

    private void addPerson() {
        System.out.print("Введіть новий ідентифікаційний код (ІПН): ");
        String code = scanner.nextLine().trim();

        if (db.getByCode(code) != null) {
            System.out.println("Людина з таким ІПН вже існує в базі.");
            return;
        }

        System.out.print("Введіть ПІБ: ");
        String name = scanner.nextLine().trim();

        System.out.print("Введіть місто: ");
        String city = scanner.nextLine().trim();

        Taxpayer taxpayer = new Taxpayer(code, name, city, new ArrayList<>());
        db.addTaxpayer(taxpayer);
        System.out.println("Людину успішно додано до бази даних.");
    }

    private void addFineToPerson() {
        System.out.print("Введіть ІПН людини для додавання штрафу: ");
        String code = scanner.nextLine().trim();

        Taxpayer taxpayer = db.getByCode(code);
        if (taxpayer == null) {
            System.out.println("Людину з таким ІПН не знайдено.");
            return;
        }

        System.out.print("Введіть тип штрафу: ");
        String type = scanner.nextLine().trim();

        System.out.print("Введіть суму штрафу: ");
        double amount = readDoubleInput();

        taxpayer.addFine(new Fine(type, amount));
        System.out.println("Штраф успішно додано.");
    }

    private void removeFine() {
        System.out.print("Введіть ІПН людини: ");
        String code = scanner.nextLine().trim();

        Taxpayer taxpayer = db.getByCode(code);
        if (taxpayer == null) {
            System.out.println("Людину з таким ІПН не знайдено.");
            return;
        }

        if (taxpayer.getFines().isEmpty()) {
            System.out.println("У цієї людини немає штрафів для видалення.");
            return;
        }

        taxpayer.printInfo();
        System.out.print("Введіть номер штрафу для видалення (1-" + taxpayer.getFines().size() + "): ");
        int index = readIntInput() - 1;

        if (taxpayer.removeFine(index)) {
            System.out.println("Штраф успішно видалено.");
        } else {
            System.out.println("Невірний номер штрафу.");
        }
    }

    private void updatePersonOrFine() {
        System.out.print("Введіть ІПН людини для редагування: ");
        String code = scanner.nextLine().trim();

        Taxpayer taxpayer = db.getByCode(code);
        if (taxpayer == null) {
            System.out.println("Людину з таким ІПН не знайдено.");
            return;
        }

        System.out.println("\nЩо саме ви хочете змінити?");
        System.out.println("1. Змінити ПІБ");
        System.out.println("2. Змінити місто");
        System.out.println("3. Редагувати існуючий штраф");
        System.out.print("Ваш вибір: ");
        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1" -> {
                System.out.print("Введіть новий ПІБ: ");
                taxpayer.setName(scanner.nextLine().trim());
                System.out.println("ПІБ оновлено.");
            }
            case "2" -> {
                System.out.print("Введіть нове місто: ");
                taxpayer.setCity(scanner.nextLine().trim());
                System.out.println("Місто оновлено.");
            }
            case "3" -> {
                if (taxpayer.getFines().isEmpty()) {
                    System.out.println("У цієї людини немає штрафів для редагування.");
                    return;
                }
                taxpayer.printInfo();
                System.out.print("Введіть номер штрафу для редагування (1-" + taxpayer.getFines().size() + "): ");
                int index = readIntInput() - 1;

                if (index >= 0 && index < taxpayer.getFines().size()) {
                    Fine fine = taxpayer.getFines().get(index);
                    System.out.print("Введіть нову суму штрафу: ");
                    fine.setAmount(readDoubleInput());
                    System.out.println("Інформацію про штраф оновлено.");
                } else {
                    System.out.println("Невірний номер штрафу.");
                }
            }
            default -> System.out.println("Невірний вибір.");
        }
    }

    private double readDoubleInput() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Невірний формат числа. Введіть ще раз: ");
            }
        }
    }

    private int readIntInput() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Невірний формат числа. Введіть ще раз: ");
            }
        }
    }
}