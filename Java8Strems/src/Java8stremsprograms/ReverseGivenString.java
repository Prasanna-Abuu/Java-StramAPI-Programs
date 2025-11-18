package Java8stremsprograms;

import java.util.Scanner;

public class ReverseGivenString {
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        System.out.println("Enter A String");
        String str = sca.nextLine();
          int len = str.length();
          System.out.println("=== Reverse a String ===");
       for(int i=len-1;i>=0;i--) {
    	   char ch = str.charAt(i);
    	 
    	   System.out.print(ch);
       }
       
      sca.close();
    }
}

/*import java.util.stream.Collectors;

public class ReverseStringJava8 {
    public static void main(String[] args) {

        String str = "Hello World";

        String reversed = str.chars()                // stream of characters (int values)
                             .mapToObj(c -> (char) c) // convert int to char
                             .reduce("", (rev, ch) -> ch + rev, (rev1, rev2) -> rev1);

        System.out.println("Original String : " + str);
        System.out.println("Reversed String : " + reversed);
    }
}*/
