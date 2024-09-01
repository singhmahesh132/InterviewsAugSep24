package SynechronForMS;

import java.util.HashMap;

//Write a java program to check if the main array contains all the numbers in sequence from below array.
public class SubsetOfArray {
    public static void main(String[] args) {
        Integer[] a1 = {1, 2, 3, 2, 1};
        Integer[] a2 = {1, 2, 3};

        HashMap<Integer, Integer> myMap = new HashMap<>();
        for (Integer num : a1) {
            myMap.put(num, (myMap.getOrDefault(num, 0) + 1));
        }

        for (Integer numToCheck : a2) {
            if (myMap.get(numToCheck) != 0) {
                int freq = myMap.get(numToCheck);
                myMap.put(numToCheck, freq - 1);
            }
            else {
                System.out.println("Number is missing");
                break;
            }
        }

        System.out.println("Numbers matched");
    }
}
