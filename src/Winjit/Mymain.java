package Winjit;

import java.util.*;

/*
Problem Statement: write a program to collect string  of same character in an array.
i/p: ["abc", "java", "def", "cba", "vaja", "efd"]
O/p: [["abc","cba"],["java","vaja"],["def","efd"]]
 */
public class Mymain {

    public static void main(String[] args){
        List<String> strList = List.of("abc", "java", "def", "cba", "vaja", "efd");

        Map<String, ArrayList<String>> myMap = new LinkedHashMap<>();

        for(String word : strList){

            char[] wordCharArr = word.toCharArray();
            Arrays.sort(wordCharArr);
            String sortedWord = new String(wordCharArr);

            /*if(myMap.containsKey(sortedWord)){
                myMap.get(sortedWord).add(word);
            }else{
                myMap.put(sortedWord, new ArrayList<>());
                myMap.get(sortedWord).add(word);
            }*/

            myMap.putIfAbsent(sortedWord, new ArrayList<>());
            myMap.get(sortedWord).add(word);
        }

        System.out.print(myMap.values());
    }
}
