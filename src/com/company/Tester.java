package com.company;

import java.util.Arrays;


public class Tester {

    // Create and return an array of random integers of size n
    private static int[] randomArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i ++) {
            array[i] = (int) (Math.random() * 100);
        }
        return array;
    }

    // Measure running time of Bubble Sort
    private static long benchmarkBubbleSort(int[] arr) {
        long startTime = System.nanoTime();
        SortAlgorithms.bubbleSort(arr);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        return timeElapsed;
    }

    // Measure running time of Selection Sort
    private static long benchmarkSelectionSort(int[] arr) {
        long startTime = System.nanoTime();
        SortAlgorithms.selectionSort(arr);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        return timeElapsed;
    }

    // Measure running time of Insertion Sort
    private static long benchmarkInsertionSort(int[] arr) {
        long startTime = System.nanoTime();
        SortAlgorithms.insertionSort(arr);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        return timeElapsed;
    }

    // Measure running time of Merge Sort
    private static long benchmarkMergeSort(int[] arr) {
        int inputSize = arr.length;  // Get the size of the array to be sorted

        long startTime = System.nanoTime();
        SortAlgorithms.mergeSort(arr, inputSize);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        return timeElapsed;
    }

    // Measure running time of Counting Sort
    private static long benchmarkCountingSort(int[] arr) {
        int inputSize = arr.length;  // Get the size of the array to be sorted

        long startTime = System.nanoTime();
        SortAlgorithms.countingSort(arr, inputSize);
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        return timeElapsed;
    }


    // Runs the specified algorithm 10 times and finds the average running time
    private static void findAverageRunTime(int arraySize, String algorithm) {
        double totalRunTime = 0;

        // Run Bubble Sort 10 times and find average running time
        if (algorithm.equals("bubbleSort")) {
            for (int i = 0; i < 10; i++) {
                long singleRunTime = benchmarkBubbleSort(randomArray(arraySize));  // Find a single run time
                totalRunTime += singleRunTime;  // Add each single run time to the total run time of all runs
            }
        }
        // Run Selection Sort 10 times and find average running time
        else if (algorithm.equals("selectionSort")) {
            for (int i = 0; i < 10; i++) {
                long singleRunTime = benchmarkSelectionSort(randomArray(arraySize));  // Find a single run time
                totalRunTime += singleRunTime;  // Add each single run time to the total run time of all runs
            }
        }
        // Run Insertion Sort 10 times and find average running time
        else if (algorithm.equals("insertionSort")) {
            for (int i = 0; i < 10; i++) {
                long singleRunTime = benchmarkInsertionSort(randomArray(arraySize));  // Find a single run time
                totalRunTime += singleRunTime;  // Add each single run time to the total run time of all runs
            }
        }
        // Run Merge Sort 10 times and find average running time
        else if (algorithm.equals("mergeSort")) {
            for (int i = 0; i < 10; i++) {
                long singleRunTime = benchmarkMergeSort(randomArray(arraySize));  // Find a single run time
                totalRunTime += singleRunTime;  // Add each single run time to the total run time of all runs
            }
        }
        // Run Counting Sort 10 times and find average running time
        else if (algorithm.equals("countingSort")) {
            for (int i = 0; i < 10; i++) {
                long singleRunTime = benchmarkCountingSort(randomArray(arraySize));  // Find a single run time
                totalRunTime += singleRunTime;  // Add each single run time to the total run time of all runs
            }
        }
        // For error handling if no valid sorting algorithm chosen
        else {
             System.out.println("Please choose a valid sorting algorithm.");
        }

        // Find and print the average running time for the specified algorithm in milliseconds
        double averageRunTime = totalRunTime / 10;  // Find the average run time
        double averageRunTimeInMillis = averageRunTime / 1000000; // Convert to milliseconds
        System.out.printf("%-11.5f", averageRunTimeInMillis);  // Print formatted output
    }

    // Main method to call other methods and create output
    public static void main(String[] args) {

        // Create formatted output table headings
        System.out.printf("%-20s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %n",
                          "Size", 100, 250, 500, 750, 1000, 1250, 2500, 3750, 5000, 6250, 7500, 8750, 10000 );

        // Create Bubble Sort output
        System.out.printf("%-20s", "Bubble Sort");
        findAverageRunTime(100, "bubbleSort");
        findAverageRunTime(250, "bubbleSort");
        findAverageRunTime(500, "bubbleSort");
        findAverageRunTime(750, "bubbleSort");
        findAverageRunTime(1000, "bubbleSort");
        findAverageRunTime(1250, "bubbleSort");
        findAverageRunTime(2500, "bubbleSort");
        findAverageRunTime(3750, "bubbleSort");
        findAverageRunTime(5000, "bubbleSort");
        findAverageRunTime(6250, "bubbleSort");
        findAverageRunTime(7500, "bubbleSort");
        findAverageRunTime(8750, "bubbleSort");
        findAverageRunTime(10000, "bubbleSort");
        System.out.printf("%n");

        // Create Selection Sort output
        System.out.printf("%-20s", "Selection Sort");
        findAverageRunTime(100, "selectionSort");
        findAverageRunTime(250, "selectionSort");
        findAverageRunTime(500, "selectionSort");
        findAverageRunTime(750, "selectionSort");
        findAverageRunTime(1000, "selectionSort");
        findAverageRunTime(1250, "selectionSort");
        findAverageRunTime(2500, "selectionSort");
        findAverageRunTime(3750, "selectionSort");
        findAverageRunTime(5000, "selectionSort");
        findAverageRunTime(6250, "selectionSort");
        findAverageRunTime(7500, "selectionSort");
        findAverageRunTime(8750, "selectionSort");
        findAverageRunTime(10000, "selectionSort");
        System.out.printf("%n");

        // Create Insertion Sort output
        System.out.printf("%-20s", "Insertion Sort");
        findAverageRunTime(100, "insertionSort");
        findAverageRunTime(250, "insertionSort");
        findAverageRunTime(500, "insertionSort");
        findAverageRunTime(750, "insertionSort");
        findAverageRunTime(1000, "insertionSort");
        findAverageRunTime(1250, "insertionSort");
        findAverageRunTime(2500, "insertionSort");
        findAverageRunTime(3750, "insertionSort");
        findAverageRunTime(5000, "insertionSort");
        findAverageRunTime(6250, "insertionSort");
        findAverageRunTime(7500, "insertionSort");
        findAverageRunTime(8750, "insertionSort");
        findAverageRunTime(10000, "insertionSort");
        System.out.printf("%n");

        // Create Merge Sort output
        System.out.printf("%-20s", "Merge Sort");
        findAverageRunTime(100, "mergeSort");
        findAverageRunTime(250, "mergeSort");
        findAverageRunTime(500, "mergeSort");
        findAverageRunTime(750, "mergeSort");
        findAverageRunTime(1000, "mergeSort");
        findAverageRunTime(1250, "mergeSort");
        findAverageRunTime(2500, "mergeSort");
        findAverageRunTime(3750, "mergeSort");
        findAverageRunTime(5000, "mergeSort");
        findAverageRunTime(6250, "mergeSort");
        findAverageRunTime(7500, "mergeSort");
        findAverageRunTime(8750, "mergeSort");
        findAverageRunTime(10000, "mergeSort");
        System.out.printf("%n");

        // Create Counting Sort output
        System.out.printf("%-20s", "Counting Sort");
        findAverageRunTime(100, "countingSort");
        findAverageRunTime(250, "countingSort");
        findAverageRunTime(500, "countingSort");
        findAverageRunTime(750, "countingSort");
        findAverageRunTime(1000, "countingSort");
        findAverageRunTime(1250, "countingSort");
        findAverageRunTime(2500, "countingSort");
        findAverageRunTime(3750, "countingSort");
        findAverageRunTime(5000, "countingSort");
        findAverageRunTime(6250, "countingSort");
        findAverageRunTime(7500, "countingSort");
        findAverageRunTime(8750, "countingSort");
        findAverageRunTime(10000, "countingSort");
        System.out.printf("%n");
    }
}
