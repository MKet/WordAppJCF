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

        return input.toLowerCase().split(",?(^|\\s)+");
    }

    public Set<String> getWordAsSet() {
        String[] split = getWords();

        SortedSet<String> words = new TreeSet<>(Collections.reverseOrder());
        words.addAll(Arrays.asList(split));

        return words;
    }
}
