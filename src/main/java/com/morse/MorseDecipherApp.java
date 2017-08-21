package com.morse;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.morse.service.Decipher;
import com.morse.service.impl.DecipherImpl;
import com.morse.util.MorseUtil;




@SpringBootApplication
public class MorseDecipherApp {

    // Logger
    private static final Logger log = LoggerFactory.getLogger(MorseDecipherApp.class);

    // Library of words
    private static final String LIB_FILENAME = "google1000.txt";



    public static void main(String[] args) {

        log.info("Init ");
        
        
        SpringApplication.run(MorseDecipherApp.class, args);
        
        

        // 1) Read the morse message
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the morse message: ");
        String morseMsg = in.next();
        log.info("phrase: " + morseMsg);


        //2) Invoke service class to solve problem
        Decipher decipher = new DecipherImpl();
        Set<String> humanSentencesResult = decipher.decipherer(morseLib(), morseMsg);

        if (humanSentencesResult.isEmpty()) {
            System.out.println("No translations for the input morse message");
        } else {
            System.out.println("Translations: ");
            for (String trans : humanSentencesResult) {
                System.out.println("Translation: " + trans);
            }
        }

        log.info("End ");
    }

    /**
     * Load the morse lib that contains the words and its corresponding morse translations.
     *
     * @return Map<String,String>
     */
    public static Map<String, String> morseLib() {
        log.info("Init morse lib");

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        // Save the pair word and morse translation
        HashMap<String, String> wordsMap = new HashMap<>();

        try {
            Scanner inputFile = new Scanner(new File(classLoader.getResource(LIB_FILENAME).getFile()));
            String wordFile;

            while(inputFile.hasNextLine()) {

                wordFile = inputFile.nextLine();

                wordsMap.put(MorseUtil.txtToMorse(wordFile), wordFile);
            }
        } catch (IOException e) {
            log.error("Error loading morse lib ", e);
        }

        log.info("End morse lib");

        return wordsMap;
    }

}
