package Matrices;

public class Matrix_Compare {
	
	   static int isSuperSimilar(int n, int m, int mat[][], int x)
	    {
	        // code here
		   int index=0;
	        for(int i=0;i<n;i++) {
	            if(i%2==0) {
//	                if(!rotate(mat[i], -1, x)) {
//	                    return 0;
//	                }
	            	index = (mat.length-(x-i))%mat.length;
	            	if(mat[i] != mat[index]) return 0;
	            } else {
//	                if(!rotate(mat[i], 1,x)) {
//	                    return 0;
//	                }
	            	index = (x+i)%mat.length;
	            	if(mat[i] != mat[index]) return 0;
	            }
	        }
	        return 1;
	    }
	    
//	    static boolean rotate(int[] arr, int dir, int rounds) {
//	        int[] temp = new int[arr.length];
//	        if(dir == -1) {
//	            for(int i=0;i<arr.length;i++) {
//	                int index = (arr.length-(rounds-i))%arr.length;
//	                temp[index]= arr[i];
//	            }
//	        } else {
//	            for(int i=0;i<arr.length;i++) {
//	                int index = (rounds+i)%arr.length;
//	                temp[index]= arr[i];
//	            }
//	        }
//	        for(int i=0;i<arr.length;i++) {
//	            if(temp[i] != arr[i]) return false;
//	        }
//	        return true;
//	    }
	    
	    public static void main(String[] args) {
			int result = isSuperSimilar(2,2,new int[][] {{1, 2},{5,6}},1);
			System.out.println(result);
		}
}
