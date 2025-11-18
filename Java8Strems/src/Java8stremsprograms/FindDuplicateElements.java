package Java8stremsprograms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDuplicateElements {
	
    public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(12, 15, 2, 4, 7, 9, 2, 15, 4);

   
    Set<Integer> uniqueElements = new HashSet<>();
   
    Set<Integer> duplicateElements = new HashSet<>();

    for (int num : numbers) {
      
        if (!uniqueElements.add(num)) {
            duplicateElements.add(num);
        }
    }

   
    System.out.println("Duplicate Elements: " + duplicateElements);
 }
}



/*import java.util.*;

public class FindDuplicateCharacters {
    public static void main(String[] args) {
        String input = "programming";

        Set<Character> uniqueChars = new HashSet<>();
        Set<Character> duplicateChars = new HashSet<>();

        for (char ch : input.toCharArray()) {
            if (!uniqueChars.add(ch)) {
                duplicateChars.add(ch);
            }
        }

        System.out.println("Duplicate characters: " + duplicateChars);
    }
}*/