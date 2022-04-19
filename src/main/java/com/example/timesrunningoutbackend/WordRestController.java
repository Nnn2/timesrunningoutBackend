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

    //TODO: getWords(int n)

    @RequestMapping("/words/{Id}")
    public Word getAttr(@PathVariable(value="Id") int id) {
        WordBankSingleton wordBank = WordBankSingleton.getInstance();
        return wordBank.getWordBank().get(id-1);
    }

    //TODO: POST request takes in a list of words and saves them to the signleton with the addWord method
}
