
package Java8stremsprograms;
import java.util.stream.IntStream;

public class FactorOfNumbers {
    public static void main(String[] args) {
        int number = 60;

        System.out.print("Factors of " + number + ": ");
        
        // Use IntStream to generate numbers from 1 to number
        IntStream.rangeClosed(1, number)
                // Filter numbers that are factors of the given number
                .filter(n -> number % n == 0)
                // Print each factor
                .forEach(factor -> System.out.print(factor + " "));
    }
}
