package WissenForJPMorgan;

/*
Given an integer array nums sorted in non-decreasing order,
remove the duplicates in-place such that each unique element appears only once.
The relative order of the elements should be kept the same.
Without using any collections or any other array and time complexity O(n).

Input:1,2,2,2,3,4,4,5,6,6
Output: 1,2,3,4,5,6,….
 */
public class RemoveDuplicatesFromArray {
    public static void main(String[] args){

        int[] arr = {1,2,2,2,3,4,4,5,6,6};
        int strPtr = 0;
        for(int i = 1; i<arr.length; i++){
            if(arr[i] != arr[strPtr]){
                arr[++strPtr] = arr[i];
            }
        }

        for(int i = 0; i <= strPtr; i++){
            System.out.print(arr[i] +" ");
        }
    }
}
