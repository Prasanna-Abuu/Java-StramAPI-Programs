// You’ve written a simple Java program that duplicates every character in a string.

package Java8stremsprograms;

public class DuplicateCharacters {

	public static void main(String[] args) {
		
		        String str = "abcd";
		        String output = duplicateCharacters(str);
		        System.out.println("Output: " + output);
		    }

		    public static String duplicateCharacters(String str) {
		        StringBuilder result = new StringBuilder();
		        for (char ch : str.toCharArray()) {
		            result.append(ch).append(ch); 
		        }
		        return result.toString();
		    }
		}