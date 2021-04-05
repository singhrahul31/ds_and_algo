package Heap;

public class BuildHeapSort {

    void buildHeap(int arr[], int n)
    {
        // Your code here
        for(int i=0;i<n;i++) {
            heapify(arr, n, i);
        }
    }

    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        // Your code here
        if(i > 0) {
            int childIdx = i;
            while(childIdx > 0) {
                int parentIdx = (childIdx-1)/2;
                if(arr[childIdx] < arr[parentIdx]) {
                    swap(arr, childIdx, parentIdx);

                }
                childIdx = parentIdx;
            }
        }

    }

    private static void swap(int[] num, int from, int to) {
        int temp = num[from];
        num[from] = num[to];
        num[to] = temp;
    }

    public void sort(int[] nums) {
        buildHeap(nums, nums.length);


    }

    public static void main(String[] args) {
        int[] values = new int[]{4,1,3,9,7};

        BuildHeapSort bd = new BuildHeapSort();
        bd.buildHeap(values, values.length);
        for(int i: values) System.out.print(i + " ");
        //System.out.println(values);
    }
}
