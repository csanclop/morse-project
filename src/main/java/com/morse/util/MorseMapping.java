package com.morse.util;

/**
 * Morse mapping for each character representation.
 *
 * @author csanchez
 */
public enum MorseMapping {

    A(".-"),
    B("-..."),
    C("-.-."),
    D("-.."),
    E("."),
    F("..-."),
    G("--."),
    H("...."),
    I(".."),
    J(".---"),
    K("-.-"),
    L(".-.."),
    M("--"),
    N("-."),
    O("---"),
    P(".--."),
    Q("--.-"),
    R(".-."),
    S("..."),
    T("-"),
    U("..-"),
    V("...-"),
    W(".--"),
    X("-..-"),
    Y("-.--"),
    Z("--..");

    private String morseValue;



    MorseMapping(String morseValue) {
        this.morseValue = morseValue;
    }

    public String getMorseValue() {
        return this.morseValue;
    }
    
}
