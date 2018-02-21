package woordenapplicatie.gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.net.URL;

import java.text.SimpleDateFormat;
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
        taInput.setText(DEFAULT_TEXT);
    }
    
    @FXML
    private void aantalAction(ActionEvent event) {
        TextProcessor processor = new TextProcessor(taInput.getText());
        long start = System.currentTimeMillis();
        taOutput.setText("Word count: " + processor.countWords());
        visualise(start);
    }

    @FXML
    private void sorteerAction(ActionEvent event) {
        TextProcessor processor = new TextProcessor(taInput.getText());
        long start = System.currentTimeMillis();
        taOutput.setText(processor.getSortedWords());
        visualise(start);
    }

    @FXML
    private void frequentieAction(ActionEvent event) {
        TextProcessor processor = new TextProcessor(taInput.getText());
        long start = System.currentTimeMillis();
        taOutput.setText(processor.frequentieWord());
        visualise(start);
    }

    @FXML
    private void concordatieAction(ActionEvent event) {
        TextProcessor processor = new TextProcessor(taInput.getText());
        long start = System.currentTimeMillis();
        taOutput.setText(processor.getConcordance());
        visualise(start);
    }

    private static void visualise(long start) {
        long end = System.currentTimeMillis();
        long nb_miliseconds = (end - start);

        System.out.println("time = " + nb_miliseconds + "ms");
    }

}
