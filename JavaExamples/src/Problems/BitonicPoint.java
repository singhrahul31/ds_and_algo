package Problems;


/**
 * Given an array Arr of N elements which is first increasing and then may be decreasing, find the maximum element in the array.
   Note: If the array is increasing then just print then last element will be the maximum value.
 * */

public class BitonicPoint {
	
    public static int findPeakElement(int[] arr) {
        int length = arr.length;
        return findMax(arr, 0, length-1);
    }
     static int findMax(int[] arr, int start, int end) {
        
        if(start == end) return start;
        
        int mid = start + (end-start)/2;
        
        if(arr[mid] < arr[mid+1]) return findMax(arr, mid+1, end);
        return findMax(arr, start, mid);
        //return -1;
    }
    
    
    public static void main(String[] args) {
		int result = findPeakElement(new int[] {1,2,3,1});
		System.out.println(result);
	}
}
