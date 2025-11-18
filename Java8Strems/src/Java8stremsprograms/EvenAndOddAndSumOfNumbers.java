package Java8stremsprograms;

import java.util.*;
import java.util.stream.Collectors;

public class EvenAndOddAndSumOfNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        // Filter odd numbers
        List<Integer> oddNumbers = numbers.stream()
                .filter(n -> n % 2 != 0)
                .collect(Collectors.toList());

        // Calculate sum of all numbers
        int sum = numbers.stream()
                .reduce(0, Integer::sum);

        // Find lowest and highest numbers
        Optional<Integer> minNumber = numbers.stream().min(Integer::compareTo);
        Optional<Integer> maxNumber = numbers.stream().max(Integer::compareTo);

        // Print results
        System.out.println("Even numbers: " + evenNumbers);
        System.out.println("Odd numbers: " + oddNumbers);
        System.out.println("Sum of all numbers: " + sum);
        System.out.println("Lowest number: " + (minNumber.isPresent() ? minNumber.get() : "No numbers"));
        System.out.println("Highest number: " + (maxNumber.isPresent() ? maxNumber.get() : "No numbers"));
    }
}

