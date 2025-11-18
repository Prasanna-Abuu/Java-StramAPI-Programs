package Java8stremsprograms;

import java.util.PriorityQueue;

public class KthLargestelementWithOutSorting {

	public static int findKthLargest(int[] nums, int k) {
		// Step 1: Create a Min Heap
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		for (int num : nums) {
			minHeap.add(num);
			System.out.println(minHeap);
			System.out.println("Size ---- " +minHeap.size());
			if (minHeap.size() > k) {
				// Remove smallest element if size > k
				minHeap.poll();
			}
		}

		// Step 3: Top of heap is the kth largest
		return minHeap.peek();
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 1, 5, 6, 4, 7 };
		int k = 1;

		int result = findKthLargest(nums, k);
		System.out.println("Kth largest element is: " + result);
	}
}

//Using Streams 


/* import java.util.Arrays;
import java.util.Comparator;

public class KthLargestelementWithOutSorting {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        
        int result = Arrays.stream(nums)
        		// Convert int[] to Stream<Integer>
                           .boxed() 
                           .sorted(Comparator.reverseOrder()) 
                           .skip(k - 1)
                           .findFirst() 
                           .get(); 

        System.out.println("Kth largest element using stream: " + result);
    }
}*/


