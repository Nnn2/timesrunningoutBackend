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
            String[] words = {
                    "Butterfly", "cup", "tea", "fire"
            };

            for (int i = 0; i < 4; i++) {
                int id = i + 1;
                String wordText = words[i];
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

    //getWords(int n) random number generator between 0 and length of wordbank,
    //add it to list of int in a while loop going n times (check that there are no duplicates of indices)
    //make a list in another loop from the indices in the previous list
    
}
