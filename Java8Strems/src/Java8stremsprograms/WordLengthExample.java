package Java8stremsprograms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordLengthExample {
    public static void main(String[] args) {
        String[] words = {"Java", "Spring", "Microservices", "API"};

        // Using Stream API to get lengths of each word
         List<Integer> wordLengths = Arrays.stream(words)
        		                         //.filter(word -> word.length()>5)
                                          .map(String::length)
                                          .collect(Collectors.toList());

        // Print the result
        System.out.println(wordLengths); 
    }
}