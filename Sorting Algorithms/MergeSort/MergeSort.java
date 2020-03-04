package com.company;

public class MergeSort {

    //merge the divided arrays
    void merge(int left[], int right[],int  resArr[]){
        int lengthLeft = left.length;
        int lengthRight = right.length;
        int lengthResArr = resArr.length;

        int i,j,k;
        i = j = k = 0;
        while(i < lengthLeft && j < lengthRight){
            if(left[i] < right[j]){
                resArr[k] = left[i];
                i++;
            }else{
                resArr[k] = right[j];
                j++;
            }
            k++;
        }
        while(i < lengthLeft){
            resArr[k] = left[i];
            i++;
            k++;
        }
        while(j < lengthRight) {
            resArr[k] = right[j];
            j++;
            k++;
        }
    }


    void mSort(int resArr[]){
        int lengthArr = resArr.length;
        if(lengthArr < 2){
            return;
        }
        int mid = lengthArr/2;
        int[] left = new int[mid];
        int[] right = new int[lengthArr-mid];
        //fill the left array
        for(int i=0; i< mid; i++){
            left[i] = resArr[i];
        }
        //fill the right array
        for(int i = mid; i < lengthArr ; i++){
            right[i - mid] = resArr[i];
        }

        //recursive calls
        mSort(left);
        mSort(right);
        merge(left, right, resArr);
    }

    //function to print the array
    static void printArray(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

    //driver function
    public static void main(String args[])
    {
        int[] arr = {209939,212,4123,1123,6324,812,5122,99213,7};
        MergeSort ms = new MergeSort();
        ms.mSort(arr);
        printArray(arr);
    }
}

