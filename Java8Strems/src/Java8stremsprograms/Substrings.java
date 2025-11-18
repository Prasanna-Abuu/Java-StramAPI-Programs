package Java8stremsprograms;

public class Substrings {
	public static void main(String[] args) {
	String str = "Prasanna";
	int len = str.length();
	for (int i = 0; i < len; i++) {
	    System.out.println("----------------------------");
	    for (int j = i + 1; j < len; j++) {
	        System.out.println(str.substring(i, j));
	    }
	}
  }
}