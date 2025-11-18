package Java8stremsprograms;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.List;

public class SumOfDigits {
	    public static void main(String[] args) {
	        List<Integer> numbers = Arrays.asList(123, 456, 789);

	        numbers.forEach(num -> {
	            int sum = String.valueOf(num)
	                            .chars()
	                            .map(Character::getNumericValue)
	                            .sum();
	            System.out.println("Sum of digits for " + num + " = " + sum);
	        });
	    }
	}

