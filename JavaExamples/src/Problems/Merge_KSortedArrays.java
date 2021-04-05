//package Problems;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class Merge_KSortedArrays {
//
//    public static List<Integer> mergeKArrays(int[][] arrays, int k)
//    {
//    	int len = arrays.length;
//    	if(len == 1) {
//    		return Arrays.asList(arrays[0]);
//    	}
//
//    	int[] result = sort(arrays[0], arrays[1]);
//		for(int i=2;i<len;i++) {
//			result =  sort(result, arrays[i]);
//		}
//
//    	return result;
//
//    }
//
//    private static int[] sort(int[] a, int[] b) {
//        int i=0;
//        int j=0;
//        int index = 0;
//        int[] result = new int[a.length+b.length];
//
//        while(i < a.length && j < b.length) {
//            if(a[i] < b[j]) {
//                result[index] = a[i];
//                i++;
//            } else {
//                result[index] = b[j];
//                j++;
//            }
//            index++;
//        }
//        while(i < a.length) {
//            result[index] = a[i];
//            i++;
//            index++;
//        }
//        while(j < b.length) {
//            result[index] = b[j];
//            j++;
//            index++;
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//		int[] result = mergeKArrays(new int[][] {{1,2,3}, {4,5,6},{7,8,9}}, 3);
//		for(int i: result) {
//			System.out.println(i);
//		}
//	}
//
//}
