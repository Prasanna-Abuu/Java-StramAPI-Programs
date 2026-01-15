package Java8stremsprograms;

import java.util.HashMap;

public class FrequencyOfElementsInArray {

	public static void main(String[] args) {
	  int[] arr = {1,1,2,2,3,4,5,5,6,7,7,8};
	  HashMap<Integer, Integer> hashMap = new HashMap<>();
	    for(int num : arr) {
	    	if(hashMap.containsKey(num)) {
	    		hashMap.put(num, hashMap.get(num)+1);
	    	}else {
	    		hashMap.put(num, 1);
	    	}
	    }
	  for(int hashMapKey: hashMap.keySet() ) {
		  System.out.println("HashMapKey:"+hashMapKey);
		  System.out.println("Frequncy Of Elements : "+hashMap.get(hashMapKey));
	  }
	  
	  
	}

}

//================================



/*public class FrequencyOfElementsInArray {

	public static void main(String[] args) {
		
		 String[] arrs = {"Tata","Prasanna","Kumar", "Tata","Prasanna","John","Arora","John"};
		  HashMap<String, Integer> hashMap = new HashMap<>();
		    for(String string : arrs) {
		    	if(hashMap.containsKey(string)) {
		    		hashMap.put(string, hashMap.get(string)+1);
		    	}else {
		    		hashMap.put(string, 1);
		    	}
		    }
		  for(String  hashMapKey:hashMap.keySet() ) {
			  System.out.println("HashMapKey:"+hashMapKey);
			  System.out.println("Frequncy Of Elements : "+hashMap.get(hashMapKey));
		  }
		  
		  	
		
	}
}

//-----------------------------------------------

/*import java.util.HashMap;

public class FrequencyOfCharactersInString {

    public static void main(String[] args) {

        String str = "programming";
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (char ch : str.toCharArray()) {
            if (hashMap.containsKey(ch)) {
                hashMap.put(ch, hashMap.get(ch) + 1);
            } else {
                hashMap.put(ch, 1);
            }
        }

        for (char key : hashMap.keySet()) {
            System.out.println("Character : " + key);
            System.out.println("Frequency : " + hashMap.get(key));
        }
    }
}*/

//---------------------------------

package com.io.program;
import java.util.*;
public class FindTheFirstReptChar {
	    public static void main(String[] args) {

	        String str = "programming";
	        HashMap<Character, Integer> hashMap = new HashMap<>();

	        for (char ch : str.toCharArray()) {
	            if (hashMap.containsKey(ch)) {
	                hashMap.put(ch, hashMap.get(ch) + 1);
	            } else {
	                hashMap.put(ch, 1);
	            }
	        }

	       /* for (char key : hashMap.keySet()) {
	            System.out.println("Character : " + key);
	            System.out.println("Frequency : " + hashMap.get(key));
	        }*/
	        
	        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
	            System.out.println("Character : " + entry.getKey());
	            System.out.println("Frequency : " + entry.getValue());
	        }
	    }
	}








