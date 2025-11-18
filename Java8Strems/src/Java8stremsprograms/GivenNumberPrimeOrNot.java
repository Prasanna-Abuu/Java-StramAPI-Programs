package Java8stremsprograms;

import java.util.stream.IntStream;

public class GivenNumberPrimeOrNot {
    public static void main(String[] args) {
        int number = 6;

        boolean isPrime = IntStream.rangeClosed(2, (int) Math.sqrt(number))
                .noneMatch(i -> number % i == 0);

        if (number > 1 && isPrime) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
    }
}
