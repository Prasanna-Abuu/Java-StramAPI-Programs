package Java8stremsprograms;

public class CountVowels {
    public static void main(String[] args) {

        String input = "PrasannaKumarTata";

        input = input.toLowerCase();

        int count = 0;

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }

        System.out.println("Number of vowels: " + count);
    }
}
