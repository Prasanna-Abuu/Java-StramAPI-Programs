package Java8stremsprograms;

import java.util.*;
import java.util.stream.Collectors;

public class NumbersStartingWith4 {
    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("123", "4056", "178", "492", "302", "4001");

        List<String> numbersStartingWithOne = numbers.stream()
                .filter(n -> n.startsWith("40"))
                //.filter(n -> n.endsWith("8"))
                .collect(Collectors.toList());

        System.out.println("Numbers starting with 40 : " + numbersStartingWithOne);
    }
}
