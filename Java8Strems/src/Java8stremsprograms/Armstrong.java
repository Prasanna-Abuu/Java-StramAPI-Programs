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

----------------------




    
public class Armstrong {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in) ;
		int aremStrong = 0;
		int temp = 0;
		System.out.println("Enter a number");
			int num = sc.nextInt();
			temp = num;
			while(num>0) {
			int rem = num%10;
			aremStrong = rem*rem*rem+aremStrong;
			 num = num/10;
			}
			if(temp == aremStrong ) {
				System.out.println(temp + " - Is AramStrong Number");
			}else {
				System.out.println(temp + " - Is not AramStrong Number");
			}
	}

}
