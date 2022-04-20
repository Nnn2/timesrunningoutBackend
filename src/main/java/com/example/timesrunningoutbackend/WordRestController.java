package com.example.timesrunningoutbackend;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class WordRestController {
    @GetMapping("/words")
    public List<Word> getWords() throws InterruptedException {
        WordBankSingleton wordBank = WordBankSingleton.getInstance();
        return wordBank.getWordBank();
    }

    @RequestMapping("/nWords/{n}")
    public List<Word> getNWords(@PathVariable(value="n") int n){
        WordBankSingleton wordBank = WordBankSingleton.getInstance();
        return wordBank.getNwords(n);
    }

    @PostMapping("/addWords")
    public List<Word> addWords(List<String> words){
        WordBankSingleton wordBank = WordBankSingleton.getInstance();
        for (int i = 0; i < words.size(); i++) {
            WordBankSingleton.addWord(words.get(i));
        }
        return null;
    }

    //change this method to get one word for the tiebreaker (use Word object throughout app to make sure we're not taking a word already part of game...?)
    @RequestMapping("/word/{Id}")
    public Word getAttr(@PathVariable(value="Id") int id) {
        WordBankSingleton wordBank = WordBankSingleton.getInstance();
        return wordBank.getWordBank().get(id-1);
    }

}
