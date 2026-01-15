
import java.util.HashMap;
import java.util.Map;

public class MajorityOfElementInArray {

    public static void main(String[] args) {

        int[] arr = {2, 2, 1, 2, 3, 2, 2};
        int n = arr.length;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        // Count frequency
        for (int num : arr) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }

        // Find majority element
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > n / 2) {
                System.out.println("Majority Element : " + entry.getKey());
                return;
            }
        }

        System.out.println("No Majority Element Found");
    }
}













---------------------------------------------------------------------


package Java8stremsprograms;


public class MajarityOfElementInArray {
public static void main(String[] args) {

	int[] nums = {3,2,3,2,2,2,2,3};
	System.out.println("Majarity Elements : "+majarityOfElement(nums)  );
}

public static int majarityOfElement(int[] nums) {
    int count = 0;
	int candidate = 0;
 for(int i=0;i<nums.length;i++) {
	  if(count == 0) {
		  candidate =nums[i];
		  System.out.println(candidate);
	  }
	  if(candidate == nums[i]) {
		  count++;
	  }else {
		  count --;
	  }
 }
return candidate;
}	
}

