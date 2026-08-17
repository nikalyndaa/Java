package org.example;

import java.util.*;

public class DictionaryApp {
    private final Map<String, WordEntity> dictionary = new LinkedHashMap<>();
    private final Scanner scan = new Scanner(System.in);

    public void seedInitialData() {
        addWordWithTranslations("apple", List.of("яблуко"));
        addWordWithTranslations("book", List.of("книга", "книжка"));
        addWordWithTranslations("cat", List.of("кіт", "кішка"));
        addWordWithTranslations("dog", List.of("пес", "собака"));
        addWordWithTranslations("house", List.of("будинок", "дім"));
        addWordWithTranslations("sun", List.of("сонце"));
        addWordWithTranslations("water", List.of("вода"));
        addWordWithTranslations("tree", List.of("дерево"));
        addWordWithTranslations("city", List.of("місто"));
        addWordWithTranslations("car", List.of("автомобіль", "машина"));
        addWordWithTranslations("river", List.of("річка"));
        addWordWithTranslations("sky", List.of("небо"));
    }

    private void addWordWithTranslations(String word, List<String> translations){
        String key = word.toLowerCase().trim();
        dictionary.put(key,new WordEntity(word,translations));
    }

    public void run() {
        while (true) {
            printMenu();
            String choice = scan.nextLine().trim();

            switch (choice) {
                case "1" -> showTranslation();
                case "2" -> addNewWord();
                case "3" -> replaceWord();
                case "4" -> removeWord();
                case "5" -> addTranslationToWord();
                case "6" -> replaceTranslationInWord();
                case "7" -> removeTranslationFromWord();
                case "8" -> showTop10Popular();
                case "9" -> showTop10Unpopular();
                case "0" -> {
                    System.out.println("Завершення роботи.");
                    return;
                }
                default -> System.out.println("Невірний вибір. Спробуйте ще раз.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\n=== АНГЛО-УКРАЇНСЬКИЙ СЛОВНИК ===");
        System.out.println("1. Знайти слово та відобразити переклади");
        System.out.println("2. Додати нове слово");
        System.out.println("3. Замінити слово (перейменувати ключ)");
        System.out.println("4. Видалити слово");
        System.out.println("5. Додати переклад до існуючого слова");
        System.out.println("6. Замінити переклад слова");
        System.out.println("7. Видалити переклад слова");
        System.out.println("8. Топ-10 найпопулярніших слів");
        System.out.println("9. Топ-10 найменш популярних слів");
        System.out.println("0. Вихід");
        System.out.print("Оберіть опцію: ");
    }

    //1 пошук слова і вивелення переклвдів
    private void showTranslation(){
        System.out.print("Введіть слово для пошуку: ");
        String word = scan.nextLine().trim().toLowerCase();

        WordEntity entry = dictionary.get(word);
        if(entry != null){
            entry.incrementAccessCount();
            System.out.println("Слово: " + entry.getWord());
            System.out.println("Переклади: " + String.join(", ", entry.getTranslations()));
            System.out.println("Кількість звернень: " + entry.getAccessCount());
        } else {
            System.out.println("Слово не знайдено в словнику.");
        }

    }

    //2 додавання нового слова
    private void addNewWord(){
        System.out.print("Введіть нове слово: ");
        String word = scan.nextLine().trim();
        String key = word.toLowerCase();

        if(dictionary.containsKey(key)){
            System.out.println("Таке слово вже існує.");
            return;
        }
        System.out.print("Введіть переклади (через кому): ");
        String[] translationArray = scan.nextLine().split(",");
        List<String> translations = new ArrayList<>();
        for(String t : translationArray){
            if(!t.isBlank()){
                translations.add(t.trim());
            }
        }

        if (translations.isEmpty()) {
            System.out.println("Переклад не може бути порожнім.");
            return;
        }

        dictionary.put(key, new WordEntity(word, translations));
        System.out.println("Слово успішно додано.");
    }

    private void replaceWord(){
        System.out.print("Введіть слово, яке хочете замінити: ");
        String oldWord = scan.nextLine().trim().toLowerCase();

        WordEntity entry = dictionary.remove(oldWord);
        if(entry == null){
            System.out.println("Слово не знайдено.");
            return;
        }

        System.out.print("Введіть нове значення слова: ");
        String newWord = scan.nextLine().trim();
        String newKey = newWord.toLowerCase();

        WordEntity newEntry = new WordEntity(newWord, entry.getTranslations());
        dictionary.put(newKey, newEntry);
        System.out.println("Слово успішно замінено.");
    }

    private void removeWord(){
        System.out.print("Введіть слово для видалення: ");
        String word = scan.nextLine().trim().toLowerCase();

        if(dictionary.remove(word) != null){
            System.out.println("Слово видалено.");
        }else{
            System.out.println("Слово не знайдено.");
        }
    }

    private void addTranslationToWord(){
        System.out.print("Введіть слово: ");
        String word = scan.nextLine().trim().toLowerCase();

        WordEntity entry = dictionary.get(word);
        if(entry != null){
            System.out.print("Введіть новий переклад: ");
            String translation = scan.nextLine().toLowerCase().trim();
            entry.addTranslation(translation);
            System.out.println("Переклад додано.");

        } else {
                System.out.println("Слово не знайдено.");
            }
    }

    private void replaceTranslationInWord(){
        System.out.print("Введіть слово: ");
        String word = scan.nextLine().trim().toLowerCase();

        WordEntity entry = dictionary.get(word);
        if (entry != null) {
            System.out.println("Поточні переклади: " + String.join(", ", entry.getTranslations()));
            System.out.print("Введіть переклад, який треба замінити: ");
            String oldTrans = scan.nextLine().trim();
            System.out.print("Введіть новий переклад: ");
            String newTrans = scan.nextLine().trim();

            if (entry.replaceTranslation(oldTrans, newTrans)) {
                System.out.println("Переклад замінено.");
            } else {
                System.out.println("Такого перекладу не знайдено.");
            }
        } else {
            System.out.println("Слово не знайдено.");
        }
    }

    private void removeTranslationFromWord(){
        System.out.print("Введіть слово: ");
        String word = scan.nextLine().trim().toLowerCase();

        WordEntity entry = dictionary.get(word);
        if( entry != null){
            if(entry.getTranslations().size() <= 1){
                System.out.println("Неможливо видалити єдиний переклад. Видаліть слово повністю.");
                return;
            }
            System.out.println("Поточні переклади: " + String.join(", ", entry.getTranslations()));
            System.out.print("Введіть переклад для видалення: ");
            String trans = scan.nextLine().trim();
            if(entry.removeTranslation(trans)){
                System.out.println("Переклад видалено.");
            }else {
                System.out.println("Такого перекладу не знайдено.");
            }
        } else {
            System.out.println("Слово не знайдено.");
        }
    }

    private void showTop10Popular() {
        System.out.println("\n--- ТОП-10 НАЙПОПУЛЯРНІШИХ СЛІВ ---");
        dictionary.values().stream()
                .sorted(Comparator.comparingInt(WordEntity::getAccessCount).reversed())
                .limit(10)
                .forEach(e -> System.out.printf("%-15s | Звернень: %d | Переклад: %s%n",
                        e.getWord(), e.getAccessCount(), String.join(", ", e.getTranslations())));
    }

    private void showTop10Unpopular() {
        System.out.println("\n--- ТОП-10 НАЙМЕНШ ПОПУЛЯРНІШИХ СЛІВ ---");
        dictionary.values().stream()
                .sorted(Comparator.comparingInt(WordEntity::getAccessCount))
                .limit(10)
                .forEach(e -> System.out.printf("%-15s | Звернень: %d | Переклад: %s%n",
                        e.getWord(), e.getAccessCount(), String.join(", ", e.getTranslations())));
    }


}
