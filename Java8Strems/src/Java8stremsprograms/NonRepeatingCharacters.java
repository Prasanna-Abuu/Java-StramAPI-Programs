package Java8stremsprograms;

import java.util.HashMap;

public class NonRepeatingCharacters {
	public static void main(String[] args) {
		String input = "programming";

		HashMap<Character, Integer> hashMap = new HashMap<>();

		for (char ch : input.toCharArray()) {

			if (hashMap.containsKey(ch)) {

				hashMap.put(ch, hashMap.get(ch) + 1);
			} else {

				hashMap.put(ch, 1);
			}
		}

		// Step 3: Print characters that appear only once
		
		for (char ch : input.toCharArray()) {
			
			if (hashMap.get(ch) == 1) {
				System.out.println("Non-repeating characters: "+ch);
			}
		}
	}
}
