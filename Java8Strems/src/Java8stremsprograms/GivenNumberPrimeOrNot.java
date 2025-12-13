package Java8stremsprograms;

import java.util.stream.IntStream;

package com.io.program;

import java.util.Scanner;

public class PrimeNumber {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in) ;
		System.out.println("Enter a number");
			int num = sc.nextInt();
		 for (int i=2;i<num;i++) {
			 if(num%i == 0) {
				 System.out.println("Given Number Is not Prime Number");
				 return;
			 }
		 }
		 System.out.println("Given Number Is Prime Number");
	}

}



//------------------------------------------------------------------


/* public class GivenNumberPrimeOrNot {
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
} */

