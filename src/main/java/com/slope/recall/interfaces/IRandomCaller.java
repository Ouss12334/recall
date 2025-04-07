package com.slope.recall.interfaces;

import com.slope.recall.data.RandomWord;

/**
 * calls random microservice api
 */
public interface IRandomCaller {

    RandomWord getRandomWord();
}
