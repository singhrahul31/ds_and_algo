package Heap;

import java.util.ArrayList;
import java.util.List;

public class MaxBinaryHeap {
    List<Integer> values;

    public MaxBinaryHeap() {
        values = new ArrayList<>();
    }

    //insert operation for max binary heap
    public List<Integer> insert(int key) {
        values.add(key);
        int index = values.indexOf(key);

        while(index > 0) {
            int parentIndex = (index - 1) / 2;
            if (values.get(parentIndex) < values.get(index)) {
                swap(values, parentIndex, index);
            }
            index = parentIndex;
        }
        return values;
    }

    // delete operation for Max Binary heap, always deletes from the top of the heap
    public int delete() {


       // if(length == 0) return null;
        int length = values.size();
        if(length == 1) {
            int value = values.remove(0);
            return value;
        }

        swap(values, 0, length-1);
        int deleted_value = values.remove(length-1);
        int startIndex = 0;
        while(true) {
            int firstIdx = (startIndex * 2) +1;
            int secondIdx = (startIndex * 2) +2;
            if(firstIdx < values.size() && values.get(firstIdx) != null) {
                if(secondIdx < values.size() && values.get(secondIdx) !=null) {
                    if(values.get(firstIdx) > values.get(secondIdx)) {
                        swap(values, startIndex, firstIdx);
                        startIndex = firstIdx;
                    } else {
                        swap(values, startIndex, secondIdx);
                        startIndex = secondIdx;
                    }
                } else {
                    if(values.get(startIndex) < values.get(firstIdx)) {
                        swap(values, startIndex, firstIdx);
                        startIndex = firstIdx;
                    } else break;
                }
            } else break;

        }
        return deleted_value;
    }

    private void swap(List<Integer> list, int pIndex, int cIndex) {
        int val = list.get(pIndex);
        list.set(pIndex, list.get(cIndex));
        list.set(cIndex, val);
    }

    public void sortHeap() {
        while(values.size() > 0) {
            int value = delete();
            System.out.print(value + " ");
        }
    }

    public void printValues() {
        if(values.size() > 1) {
            for(int i: values) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        MaxBinaryHeap mp = new MaxBinaryHeap();
        mp.insert(20);
        mp.insert(30);
        mp.insert(50);
        mp.insert(12);
        mp.insert(8);
        mp.insert(15);
        mp.insert(10);
        mp.insert(60);
        mp.insert(32);
        mp.insert(49);
        mp.printValues();
        System.out.println("*****");
        mp.sortHeap();

    }
}
