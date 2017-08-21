package com.morse.service;

import java.util.Map;
import java.util.Set;

/**
 * Morse Decipher interface.
 *
 * @author csanchez
 */
public interface Decipher {



    /**
     * Returns all combinations for the input morse message". 
     *
     * @param morseLib Map with morse words. The key is the morse value  and the value is the text.     
     * @param msg The message to decipher.
     * @return Set<String> with all combinations
     */
    Set<String> decipherer(Map<String, String> morseLib, String msg);


}
