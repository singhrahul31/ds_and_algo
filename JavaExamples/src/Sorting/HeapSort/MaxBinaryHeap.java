package Sorting.HeapSort;

import java.util.Objects;

public class MaxBinaryHeap {

    static void createHeap(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            if(!Objects.isNull(arr[i])) {
                maxBinaryHeap(i, arr);
            }
        }

        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
    static void maxBinaryHeap(int pos, int[] arr) {
        int leftchild = (pos * 2) +1;
        int rightChild = (pos*2) +1;
        if(rightChild <= arr.length-1 && (arr[pos] < arr[leftchild] && arr[pos] < arr[rightChild])) {
            if(arr[leftchild] >= arr[rightChild]) {
                swap(arr, pos, leftchild);
            } else {
                swap(arr, pos, rightChild);
            }
        }

    }

    static void swap(int[] num,int i,int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static void main(String[] args) {
        int[] values = {4,6,3,5,2};
        createHeap(values);
    }
}
