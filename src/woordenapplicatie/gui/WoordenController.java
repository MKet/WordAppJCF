package woordenapplicatie.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.net.URL;

import java.util.*;

import java.util.Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author frankcoenen
 */
public class WoordenController implements Initializable {
    
   private static final String DEFAULT_TEXT =   "Een, twee, drie, vier\n" +
                                                "Hoedje van, hoedje van\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "Heb je dan geen hoedje meer\n" +
                                                "Maak er één van bordpapier\n" +
                                                "Eén, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van, hoedje van\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier\n" +
                                                "\n" +
                                                "En als het hoedje dan niet past\n" +
                                                "Zetten we 't in de glazenkas\n" +
                                                "Een, twee, drie, vier\n" +
                                                "Hoedje van papier";
    
    @FXML
    private Button btAantal;
    @FXML
    private TextArea taInput;
    @FXML
    private Button btSorteer;
    @FXML
    private Button btFrequentie;
    @FXML
    private Button btConcordantie;
    @FXML
    private TextArea taOutput;

    private Map<String, Long> frequencieMap;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taInput.setText(DEFAULT_TEXT);
    }
    
    @FXML
    private void aantalAction(ActionEvent event)
    {
         System.out.println(countWords(taInput.getText()));
    }

    @FXML
    private void sorteerAction(ActionEvent event) {
        List<String> words = getWords();

        words.sort(Collections.reverseOrder());

        StringBuilder wordString = new StringBuilder();
        for (String word : words)
            wordString.append(" ").append(word);

        taOutput.setText(wordString.toString());

    }

    @FXML
    private void frequentieAction(ActionEvent event) {
         throw new UnsupportedOperationException("Not supported yet."); 
    }

    @FXML
    private void concordatieAction(ActionEvent event) {
         throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void frequencieWord(String s) {
        Stream<String> stream = Stream.of(taInput.getText().toLowerCase().split("\\W+")).parallel();
        frequencieMap = stream.collect(Collectors.groupingBy(String::toString, Collectors.counting()));
        System.out.println(frequencieMap);
    }

    private List<String> getWords() {
        String input = taInput.getText();

        String[] split = input.toLowerCase().split(",?(^|\\s)+");

        return new ArrayList<>(Arrays.asList(split));
    }

    public int countWords(String s){

        int wordCount = 0;

        boolean word = false;
        int endOfLine = s.length() - 1;

        for (int i = 0; i < s.length(); i++) {
            // if the char is a letter, word = true.
            if (Character.isLetter(s.charAt(i)) && i != endOfLine) {
                word = true;
                // if char isn't a letter and there have been letters before,
                // counter goes up.
            } else if (!Character.isLetter(s.charAt(i)) && word) {
                wordCount++;
                word = false;
                // last word of String; if it doesn't end with a non letter, it
                // wouldn't count without this.
            } else if (Character.isLetter(s.charAt(i)) && i == endOfLine) {
                wordCount++;
            }
        }
        return wordCount;
    }

}
