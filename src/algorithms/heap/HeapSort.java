package algorithms.heap;

import java.util.Arrays;
// when would you use heaps? For priority queue implementation.
//
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {10,3,4,52,5,2};
        heapSort(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    static void heapSort(int[] arr){
        buildMaxHeap(arr);
        for(int i = 1;i<arr.length;i++){
            int temp = arr[arr.length -i];
            arr[arr.length - i] = arr[0];
            arr[0] = temp;
            maxHeapify(arr,0,arr.length - i);
        }
    }

    // time complexity is O(n)
    // for nodes that are one level above leaves, will take constant time.
    // and in general nodes that are l level above the leaves will take O(l)
    // 1. There are n/4 nodes that are 1 level , n/8 that are at level 2 from leaves.... 1 node at the top
    // Total amount of work done will be n/4 + n/8 + n/16 ..... + 1logn
    //
    static void buildMaxHeap(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            maxHeapify(arr, i, arr.length);
        }
    }

    // time complexity is O(log n)
    static void maxHeapify(int[] arr, int index, int size) {
        if (index >= size || 2 * index + 1 >= size) return;
        int maxIndex = index;
        int maxValue = arr[index];
        if (arr[2 * index + 1] > maxValue) {
            maxIndex = 2 * index + 1;
            maxValue = arr[2 * index + 1];
        }
        if (2 * index + 2 < size && arr[2 * index + 2] > maxValue) {
            maxIndex = 2 * index + 2;
            maxValue = arr[2 * index + 2];
        }
        if (maxIndex != index) {
            int temp = arr[index];
            arr[index] = maxValue;
            arr[maxIndex] = temp;
            maxHeapify(arr, maxIndex, size);
        }
    }
}
