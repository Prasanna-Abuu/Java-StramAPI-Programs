package Java8stremsprograms;

public class SubsequencesOfAnArray {

	public static void main(String[] args) {
		int[] arr = {1,3,5,7};
	    int len = arr.length;
	    for(int i=0;i<len;i++) {
	    	//System.out.println("-------------------------------------------");
	     for(int j=i;j<len;j++) {
	    	 int temp =0;
	    		for(int k=i;k<=j;k++) {
	    			System.out.print(arr[k]+" "); 
	    			// temp = temp + arr[k];
	    		 }
	    		//System.out.println(" = SubsequencesOfAnArray Sum -----> : " + temp);
	    		 System.out.println();
	    	 }
	    
	    }

	}

}
