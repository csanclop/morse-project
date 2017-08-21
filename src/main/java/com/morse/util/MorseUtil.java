package com.morse.util;

/**
 * Utility class for all related morse operations.
 *
 * @author csanchez
 */
public class MorseUtil {

    /**
     * Convert normal text to morse.
     *
     * @param clearTxt Word thant you want to translate to morse.
     * @return Word converted to morse.
     */
    public static String txtToMorse(String clearTxt) {
        String morseWord = null;

        if(clearTxt != null && !clearTxt.isEmpty()) {
            morseWord = "";

            for(int i = 0; i < clearTxt.length(); i++) {
                String character = Character.toString(clearTxt.charAt(i));

                morseWord += MorseMapping.valueOf(character.toUpperCase()).getMorseValue();
            }
        }

        return morseWord;
    }
}
