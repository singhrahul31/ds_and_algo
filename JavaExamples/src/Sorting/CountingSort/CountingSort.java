package Sorting.CountingSort;

public class CountingSort {

    public static void countingSort(int[] num) {
        int max =0;
        for(int i=0;i<num.length;i++) {
            max = Math.max(max,num[i]);
        }
        int[] countArr = new int[max+1];
//        for(int i=0;i<countArr.length;i++) {
//            countArr[i] =0;
//        }
        int[] resultArr = new int[num.length];
        int[] result = count(num, countArr, resultArr);
        for(int i=0;i<result.length;i++) {
            System.out.println(result[i]);
        }
    }

    private static int[] count(int[] inpArr, int[] count, int[] otpArr) {
        for(int i=0;i< inpArr.length;i++) {
            count[inpArr[i]]++;
        }
        for(int i=1;i<count.length;i++) {
            count[i] = count[i] + count[i-1];
        }
        for(int i=otpArr.length-1;i>=0;i--) {
            otpArr[count[inpArr[i]] -1] = inpArr[i];
            count[inpArr[i]]--;
        }
        return otpArr;
    }

    public static void main(String[] args) {
        int[] values = {6,8,7,2,5,2,34,12,8,16,22,30,1,9,19};
        countingSort(values);
    }
}
