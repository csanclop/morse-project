package com.morse.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.morse.service.Decipher;

import java.util.*;

/**
 * Decipher Facade.
 *
 * @author csanchez
 */
public class DecipherImpl implements Decipher {

    private static final Logger log = LoggerFactory.getLogger(DecipherImpl.class);


    // morse library
    private Map<String, String> morseLib;

    // new words will be added. Accumulative collection where the results will be stored
    private Set<String> partialLib;


    /**
     * Constructor.
     */
    public DecipherImpl() {
        this.partialLib = new HashSet<>();
    }

    @Override
    public Set<String> decipherer(Map<String, String> morseLib, String message) {
        log.info("Init morse deciphering");

        // clear the collection
        this.partialLib.clear();

        // save morse lib
        this.morseLib = morseLib;

        // recursive invocation for whole input morse message
        decipherRecursive(message, "");

        log.info("End morse deciphering");
        return this.partialLib;
    }

    /**
     * Recursive method to retriev all combinations for input message.
     *
     * @param message input morse message.
     * @param result input translation result.
     */
    private void decipherRecursive(String message, String result) {
        
        Set<String> wordsSet = new HashSet<>();

        int count = 0;
        String morseWord = "";


        while (count <= message.length() - 1) {
            morseWord += message.substring(count, count + 1);

            if (this.morseLib.containsKey(morseWord)) {
                if (!wordsSet.contains(morseWord)) {

                    wordsSet.add(morseWord);

                    decipherRecursive(message.substring(morseWord.length(), message.length()),
                            result + this.morseLib.get(morseWord) + " ");
                }
            }

            count++;

        }


        if(!result.isEmpty() && !" ".equals(result))
            this.partialLib.add(result);
    }
}
