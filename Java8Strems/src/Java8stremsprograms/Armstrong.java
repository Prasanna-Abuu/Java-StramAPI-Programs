package Java8stremsprograms;

import java.util.Scanner;

public class Armstrong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        scanner.close();

        boolean isArmstrong = String.valueOf(number)
                .chars()
                .map(Character::getNumericValue) 
                .mapToDouble(digit -> Math.pow(digit, String.valueOf(number).length())) // Calculate the cube of each digit
                .sum() == number; 
        if (isArmstrong) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
    }
}
