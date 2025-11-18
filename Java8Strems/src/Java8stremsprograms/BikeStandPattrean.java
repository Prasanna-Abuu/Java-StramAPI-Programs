package Java8stremsprograms;

public class BikeStandPattrean {
	 public static void main(String[] args) {
	       int r = 9;
	       int c = 8;
	       for(int i=0;i<c;i++){
	           for(int j=0;j<r-i;j++){
	               System.out.print(" ");
	           }
	           for(int k=0;k<c;k++){
	               System.out.print("*");
	           }
	            System.out.println();
	       }
	      
	    }
	}