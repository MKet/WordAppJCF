package woordenapplicatie;

import java.util.*;

public class TextProcessor {

    private String Text;

    public TextProcessor(String text) {
        Text = text;
    }


    public String frequentieWord() {
        Map<String, Integer> frequentieMap = new HashMap<>();
        for (String w : getWords()){
            Integer n = frequentieMap.get(w);

            if (n == null) {
                frequentieMap.put(w, 1);
            } else {
                frequentieMap.replace(w, n+1);
            }
        }
        return frequentieMap.toString();
    }

    public int countWords(String s){
        return getWords().length;
    }

    public String getConcordance() {
        Map<String, Set<Integer>> map = new HashMap<>();

        String[] split = Text.split("\n+");

        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            String[] wordSplit = s.split(",?\\s+");

            for (String word : wordSplit) {
                Set<Integer> integers = map.computeIfAbsent(word, k -> new HashSet<>());

                integers.add(i+1);
            }
        }

        StringBuilder sb = new StringBuilder();

        map.forEach((k, integers) -> {
            sb.append(k);
            sb.append(" [ ");

            for (int i : integers) {
                sb.append(i);
                sb.append(" ");
            }
            sb.append(" ]\n");
        } );

        return sb.toString();
    }

    public String getSortedWords() {
        final Set<String> words = getWordAsSet();

        StringBuilder wordString = new StringBuilder();
        for (String word : words)
            wordString.append(word).append("\n");

        return wordString.toString();
    }

    public List<String> getWordsAsList() {
        String[] split = getWords();

        return new ArrayList<>(Arrays.asList(split));
    }

    public String[] getWords() {
        String input = Text;

        return input.split(",?(^|\\s)+");
    }

    public Set<String> getWordAsSet() {
        SortedSet<String> words = new TreeSet<>(Collections.reverseOrder());
        words.addAll(getWordsAsList());

        return words;
    }
}
