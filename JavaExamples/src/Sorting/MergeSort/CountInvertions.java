package Sorting.MergeSort;

public class CountInvertions {

    public static long countInvertions(int[] arr) {
       return merge(arr, new int[arr.length], 0, arr.length-1);
    }

    public static long merge(int[] num, int[] temp,int startIdx,int endIdx) {
        long count =0L;
        if(startIdx < endIdx) {
            int mid = (startIdx+endIdx) /2;
            count += merge(num, temp, startIdx, mid);
            count += merge(num, temp, mid+1, endIdx);
            count += sort(num, temp, startIdx, endIdx);
        }
        return count;
    }

    public static long sort(int[] num, int[] temp,int start,int end) {

        int mid = (start+end)/2;
        int i=start;
        int j = mid+1;
        int index = start;
       int  count =0;
        while(i <= mid && j<= end) {
            if(num[i] <= num[j]) {
                temp[index++] = num[i++];
            } else {
                count += mid-i+1;
                temp[index++] = num[j++];
            }
        }
        while(i <= mid) {
            temp[index++] = num[i++];
        }
        while(j<= end) {
            temp[index++] = num[j++];
        }
        System.arraycopy(temp, start, num, start, end-start+1);
        return count;
    }

    public static void main(String[] args) {
        int[] values = {3 ,2, 1};
        System.out.println(countInvertions(values));
    }
}
