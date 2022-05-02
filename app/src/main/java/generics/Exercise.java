package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise {

    public static String sortLetters(String word) {
        return Stream.of(word.split(""))
            .sorted()
            .collect(Collectors.joining());
    }

    public static List<String> findSetOfWords(String sortedWord, List<String> words) {
        return words.stream()
            .filter(word -> sortLetters(word).equals(sortedWord))
            .toList();
    }
    
    public static void main(String[] args) {
        
        List<String> words = new ArrayList<>(List.of("adn", "abn", "bna", "dan", "axy", "nda"));
        List<List<String>> setsOfWords = new ArrayList<>();

        var sortedWords = words.stream()
            .map(Exercise::sortLetters)
            .toList();

        for (String word : sortedWords) {
            var setOfEqualWords = findSetOfWords(word, words);
            words.removeAll(setOfEqualWords);
            if (setOfEqualWords.size() > 0)
                setsOfWords.add(setOfEqualWords);
        }

        setsOfWords.forEach(listOfWords -> System.out.println(listOfWords.toString()));
    }
}
