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
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import woordenapplicatie.TextProcessor;

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Map<String, Integer>frequencieMap = new HashMap<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        taInput.setText(DEFAULT_TEXT);
    }
    
    @FXML
    private void aantalAction(ActionEvent event) {
        TextProcessor processor = new TextProcessor(taInput.getText());
        taOutput.setText("Word count: " + processor.countWords(taInput.getText()));
    }

    @FXML
    private void sorteerAction(ActionEvent event) {
        TextProcessor processor = new TextProcessor(taInput.getText());
        taOutput.setText(processor.getSortedWords());
    }

    @FXML
    private void frequentieAction(ActionEvent event) {
        TextProcessor processor = new TextProcessor(taInput.getText());
        taOutput.setText(processor.frequentieWord());
    }

    @FXML
    private void concordatieAction(ActionEvent event) {
        TextProcessor processor = new TextProcessor(taInput.getText());
        taOutput.setText(processor.getConcordance());
    }

    public String frequencieWord() {
        StringBuilder sb = new StringBuilder();
        for (String w : getWords()){
            Integer n = frequencieMap.get(w);
            n = (n == null) ? 1 : ++n;
            frequencieMap.put(w,n);

            sb.append(w);
            sb.append(" = ");
            sb.append(n);
            sb.append("\n");
        }

        return sb.toString();
    }

    public int countWords(String s) {

        int wordCount = 0;

        boolean word = false;
        int endOfLine = s.length() - 1;
    }

}
