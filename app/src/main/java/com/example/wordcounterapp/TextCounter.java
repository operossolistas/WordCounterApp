package com.example.wordcounterapp;

public class TextCounter {
    public static int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }
        return text.trim().split("\\s+").length;
    }

    public static int countCharacters(String text) {
        if (text == null) {
            return 0;
        }
        return text.length();
    }
} 