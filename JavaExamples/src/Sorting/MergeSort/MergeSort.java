package Sorting.MergeSort;


public class MergeSort {

    public int[] mergeSort(int[] num) {

        return merge(num, new int[num.length], 0, num.length - 1);
    }

    public int[] merge(int[] num, int[] temp, int startIdx, int endIdx) {

        if (startIdx < endIdx) {
            int mid = (startIdx + endIdx) / 2;
            merge(num, temp, startIdx, mid);
            merge(num, temp, mid + 1, endIdx);
            sort(num, temp, startIdx, endIdx);
        }
        return temp;

    }

    public void sort(int[] num, int[] temp, int start, int end) {
        int mid = (start + end) / 2;
        int i = start;
        int j = mid + 1;
        int index = start;

        while (i <= mid && j <= end) {
            if (num[i] <= num[j]) {
                temp[index] = num[i];
                i++;
            } else {
                temp[index] = num[j];
                j++;
            }
            index++;
        }

        // System.out.println("I: "+i+" J: "+j);
        while (i <= mid) {
            temp[index] = num[i];
            i++;
            index++;
        }

        while (j <= end) {
            temp[index] = num[j];
            j++;
            index++;
        }

        // for(int k=start;k<=end;k++) {
        //     num[k] = temp[k];
        // }
        System.arraycopy(temp, start, num, start, end-start+1);

    }

    public static void main(String[] args) {

        int[] values = { 2,1,3,1,2};

        MergeSort ms = new MergeSort();
        int[] result = ms.mergeSort(values);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}