package com.slope.recall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.slope.recall.data.RandomWord;
import com.slope.recall.interfaces.IRandomCaller;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/caller")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class RandomizerCallerController {

    private IRandomCaller randomCaller;
    
    @GetMapping("/random")
    public RandomWord getRandomWord() {
        return randomCaller.getRandomWord();
    }

}
