package Java8stremsprograms;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SortedArray {
	  public static void main(String[] args) {
		  Integer[] arrs = {3,2,5,6,3,8,10};
		  // Adding ArraysList to Set
		 Set<Integer> set = new HashSet<>(Arrays.asList(arrs));
		 // Converting Set to Array
		 Integer[] uniqueArray = set.toArray(new Integer[0]);
		  Arrays.sort(uniqueArray, Collections.reverseOrder());
		  System.out.println("Sorted Array : "+Arrays.toString(uniqueArray));
		  
		  }
	}