package com.example.timesrunningoutbackend;
import org.thymeleaf.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBankSingleton {

    private static WordBankSingleton instance;
    private static List<Word> wordBank;
    private static int lastID;

    public static WordBankSingleton getInstance() {
        if (instance == null) {
            instance = new WordBankSingleton();
            wordBank = new ArrayList<>();

            // String array containing 4 words.
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
        int[] indices = new int[n];
        Arrays.fill(indices, -1);
        List<Word> words = new ArrayList<>();
        while(i < n) {
            int index = -1;
            while(contains(indices,index)) {
                index = (int) ((Math.random() * (wordBank.size())));
            }
            indices[i] = index;
            words.add(wordBank.get(index));
            i++;
        }
        return words;
    }

    private static boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }

    public static void addWord(String wordString) {
        Word word = new Word(lastID+1, wordString);
        wordBank.add(word);
    }

}
