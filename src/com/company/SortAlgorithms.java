package com.company;

public class SortAlgorithms {

    // Bubble Sort (source: GMIT lecture notes)
    public static void bubbleSort(int[] arr) {
        int outer, inner;
        for (outer = arr.length -1; outer > 0; outer--) {   // Moving left from the last element/second last element/etc
            for (inner = 0; inner < outer; inner++) {  // Checking if the current element is greater than its right neighbour
                if (arr[inner] > arr[inner + 1]) {   // If out of order... (eg, arr[arr.length - 2] > arr[arr.length - 1])
                    int temp = arr[inner];  // ...then swap their positions
                    arr[inner] = arr[inner + 1]; // Assigns the value of the smaller right element to the left index
                    arr[inner + 1] = temp;  // Assigns the value of the larger left element to the right index
                }
            }
        }
    }

    // Selection Sort (source: GMIT lecture notes)
    public static void selectionSort(int[] arr) {
        int outer=0, inner = 0, min = 0;
        for (outer = 0; outer < arr.length - 1; outer++) {  // outer counts up
            min = outer;
            for (inner = outer + 1; inner < arr.length; inner++) {
                if (arr[inner] < arr[min]) {  // find index of smallest value
                    min = inner;  // set min to the smallest value
                }
            }

            // swap arr[min] with arr[outer]
            int temp = arr[outer];
            arr[outer] = arr[min];
            arr[min] = temp;
        }
    }

    // Insertion Sort (source: GMIT lecture notes)
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];  // set key variable to the value to be inserted
            int j = i - 1;  // use index j for checking elements to the left of the key
            // move all elements greater than the key right by one position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;  // insert key in its new position
        }
    }

    // Merge Sort (source: https://www.baeldung.com/java-merge-sort)
    public static void mergeSort(int[] arr, int arrayLength) {
        if (arrayLength <= 1) {  // Return if the input size is 0 or 1
            return;
        }

        int middleIndex = arrayLength / 2;  // Find middle index, and store both halves in temporary arrays l and r.
        int[] l = new int[middleIndex];
        int[] r = new int[arrayLength - middleIndex];

        for (int i = 0; i < middleIndex; i++) {
            l[i] = arr[i];
        }
        for (int i = middleIndex; i < arrayLength; i++) {
            r[i - middleIndex] = arr[i];
        }

        // Call mergeSort function recursively on l and r
        mergeSort(l, middleIndex);
        mergeSort(r, arrayLength - middleIndex);

        // merge the temporary arrays together again with the merge function
        merge(arr, l, r, middleIndex, arrayLength - middleIndex);
    }

    public static void merge(int[] arr, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;

        // Compare the elements of both subarrays, placing the smaller element into the input array arr
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                arr[k++] = l[i++];
            }
            else {
                arr[k++] = r[j++];
            }
        }

        // Copy the rest of the elements from the other array into the input array arr
        while (i < left) {
            arr[k++] = l[i++];
        }
        while (j < right) {
            arr[k++] = r[j++];
        }
    }

    // Counting Sort (source: https://www.programiz.com/dsa/counting-sort)
    public static void countingSort(int[] arr, int arrayLength) {

        // The output  array that will be used to store sorted output
        int[] output = new int[arrayLength + 1];

        // Loop over array to find the largest element of the array, called max
        int max = arr[0];
        for (int i = 1; i < arrayLength; i++) {
            if (arr[i] > max) {  // If the current element is larger than max
                max = arr[i];  // Set max to that elements value
            }
        }

        // Create a count array of length max + 1 to store frequency of inidividul elements
        int[] count = new int[max + 1];
        for (int i = 0; i < max; i++) {
            count[i] = 0; // Initialize each element of count to 0
        }

        // Store the count/frequency of each element at its respective index in count array
        for (int i = 0; i < arrayLength; i++) {
            count[arr[i]]++;
        }

        // Store the cummulative sum of elements in the count array
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Find the index of each element of the original array in the count array, and
        // place the elements in the output array.
        for (int i = arrayLength - 1; i >= 0; i--) {
            // Find the index of each element of the original array in the count array
            output[count[arr[i]] - 1] = arr[i];
            // Build the output  array in reverse order from the last index.
            count[arr[i]]--;
        }

        // Copy the sorted elements into original array
        for (int i = 0; i < arrayLength; i++) {
            arr[i] = output[i];
        }
    }
}
