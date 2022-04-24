package com.example.timesrunningoutbackend;
import org.thymeleaf.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WordBankSingleton {

    private static WordBankSingleton instance;
    private static List<Word> wordBank;
    private static int lastID;

    public static WordBankSingleton getInstance() {
        if (instance == null) {
            instance = new WordBankSingleton();
            wordBank = new ArrayList<>();

            // String array containing 4 words for demo.
            String[] words = {
                    "Butterfly", "cup", "tea", "fire"
            };

            for (int i = 0; i < words.length; i++) {
                int id = i + 1;
                String wordText = words[i];
                Word word = new Word(id, wordText);
                wordBank.add(word);
                lastID = i;
            }
        }
        return instance;
    }

    private WordBankSingleton() {
    }

    public List<Word> getWordBank() {
        return wordBank;
    }

    //getWords(int n) random number generator between 0 and length of wordbank,
    //add it to list of int in a while loop going n times (check that there are no duplicates of indices)
    //make a list in another loop from the indices in the previous list
    public List<Word> getNwords(int n) {
        int i = 0;
        List<Word> words = new ArrayList<>();
        Collections.shuffle(wordBank);
        while(i < n) {
            words.add(wordBank.get(i));
            i++;
        }
        return words;
    }

    public static void addWord(String wordString) {
        Word word = new Word(lastID+1, wordString);
        wordBank.add(word);
    }

}
