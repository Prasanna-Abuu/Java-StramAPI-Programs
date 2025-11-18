package Java8stremsprograms;

public class SubsequenceString {

    public static void generateSubsequences(String str, String result, int index) {
        if (index == str.length()) {
            System.out.println(result);
            return;
        }

        // Include the current character
        generateSubsequences(str, result + str.charAt(index), index + 1);

        // Exclude the current character
        generateSubsequences(str, result, index + 1);
    }

    public static void main(String[] args) {
        String s = "Hello";
        System.out.println("All subsequences of \"" + s + "\":");
        generateSubsequences(s, "", 0);
    }
}