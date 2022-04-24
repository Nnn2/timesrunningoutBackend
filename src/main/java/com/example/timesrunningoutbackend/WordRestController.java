package com.example.timesrunningoutbackend;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/addWord")
    public String addWord(String word){
        WordBankSingleton wordBank = WordBankSingleton.getInstance();
        wordBank.addWord(word);
        return word;
    }

    @RequestMapping("/word/{Id}")
    public Word getAttr(@PathVariable(value="Id") int id) {
        WordBankSingleton wordBank = WordBankSingleton.getInstance();
        return wordBank.getWordBank().get(id-1);
    }

}
