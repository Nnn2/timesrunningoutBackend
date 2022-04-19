package com.example.timesrunningoutbackend;
import java.util.ArrayList;
import java.util.List;

public class WordBankSingleton {

    private static WordBankSingleton instance;
    private List<Word> wordBank;

    public static WordBankSingleton getInstance() {
        if (instance == null) {
            instance = new WordBankSingleton();
            instance.wordBank = new ArrayList<>();

            // String array containing 4 words.
            String[] questions = {
                    "Butterfly", "cup", "tea", "fire"
            };

            for (int i = 0; i < 4; i++) {
                int id = i + 1;
                String wordText = questions[i];
                Word word = new Word(id, wordText);
                instance.wordBank.add(word);
            }
        }
        return instance;
    }

    private WordBankSingleton() {
    }

    public List<Word> getWordBank() {
        return wordBank;
    }

    public void addWord(Word word) {
        wordBank.add(word);
    }
}
