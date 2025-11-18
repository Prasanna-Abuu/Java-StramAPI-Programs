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
