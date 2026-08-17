package org.example;

import java.util.List;

public class WordEntity {

    private final String word;
    private final List<String> translations;
    private int accessCount;

    public WordEntity(String word, List<String> translations) {
        this.word = word;
        this.translations = translations;
        this.accessCount = 0;
    }

    public String getWord() {
        return word;
    }

    public List<String> getTranslations() {
        return translations;
    }

    public int getAccessCount() {
        return accessCount;
    }

    public void incrementAccessCount() {
        this.accessCount++;
    }

    public void addTranslation(String translation){
        if(!translations.contains(translation)){
            translations.add(translation);
        }
    }

    public boolean removeTranslation(String translation){
        return translations.remove(translation);
    }

    public boolean replaceTranslation(String oldTranslation, String newTranslation){
        int index = translations.indexOf(oldTranslation);
        if(index != -1){
            translations.set(index, newTranslation);
            return true;
        }
        return false;
    }
}
