package com.example.timesrunningoutbackend;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class WordRestController {
    @GetMapping("/words")
    public List<Word> getWords() throws InterruptedException {
        WordBankSingleton wordBank = WordBankSingleton.getInstance();
        //TimeUnit.SECONDS.sleep(3);
        return wordBank.getWordBank();
    }

    @RequestMapping("/words/{Id}")
    public Word getAttr(@PathVariable(value="Id") int id) {
        WordBankSingleton wordBank = WordBankSingleton.getInstance();
        return wordBank.getWordBank().get(id-1);
    }
}
