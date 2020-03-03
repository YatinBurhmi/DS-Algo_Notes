package com.company;

// Java program for implementation of QuickSort
class QuickSort
{
    int partition(int arr[], int start, int end){
        int pivot = arr[end]; //selecting pivot as last element in the array
        int pIndex = start;  //pIndex will be the position of pivot element after partitioning is done
        for(int i = start; i < end; i++){
            if(arr[i] < pivot){
                //swap arr[i] and arr[pIndex]
                int temp = arr[i];
                arr[i] = arr[pIndex];
                arr[pIndex] = temp;

                //increment pIndex
                pIndex++;
            }
        }
        //swap element at pIndex
        arr[end] = arr[pIndex];
        arr[pIndex] = pivot;
        return pIndex;
    }

    void qsort(int arr[], int start, int end){
        if(start < end) {
            int pivotIndex = partition(arr,start,end);
        /*  call the qsort method recursively on the
            two sublists created on the left of the
            pivot and on the right of the pivot
         */
            qsort(arr, start, pivotIndex-1);
            qsort(arr,pivotIndex+1,end);
        }
    }


    //funciton to print the array
    static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

    //driver function
    public static void main(String args[])
    {
        int arr[] = {58389,8946,556,678,2231,381};
        QuickSort qs = new QuickSort();
        qs.qsort(arr,0,arr.length-1);
        System.out.println("sorted array");
        printArray(arr);
    }
} 
