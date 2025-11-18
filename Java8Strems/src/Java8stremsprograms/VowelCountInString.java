package Java8stremsprograms;

import java.util.List;

public class VowelCountInString {

	    public static void main(String[] args) {
	        String s = "PrasannaKumar";
	        char[] characters = s.toCharArray();
	        int count = 0;

	        for (char c : characters) {
	            if (List.of('a', 'e', 'i', 'o', 'u').contains(c)) {
	                count++;
	            }
	        }

	        System.out.println("Number of vowels: " + count);
	    }
	}
