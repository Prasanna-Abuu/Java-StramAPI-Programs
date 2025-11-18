package Java8stremsprograms;

public class SubarrayGenerator {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            System.out.println("----------------------------");
            for (int j = i + 1; j <= len; j++) {
                // Print subarray from i to j-1
                for (int k = i; k < j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }
    }
}
