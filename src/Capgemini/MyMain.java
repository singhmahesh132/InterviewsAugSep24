package Capgemini;

import java.util.*;

/*
Given a list of string,
Using streams write a program which skip numbers
and then sort the list on basis of second character of the string
 */
public class MyMain {

    public static void main(String[] args) {

        List<String> mylist = List.of("Java", "World", "Mahesh", "12345", "203040", "Capgemini","a2bc");
        mylist.stream()
                .filter(word -> !word.matches("\\d+"))
                .sorted((s1,s2) -> Character.compare(s1.charAt(1), s2.charAt(2)))
                .forEach(System.out::println);

        /*
        public static class StringComparator implements Comparator<String>{
            public int compare(String s1, String s2){
                char s1Char = s1.toCharArray()[1];
                char s2Char = s2.toCharArray()[1];
                if(s1Char < s2Char)
                    return -1;
                else if(s1Char > s2Char)
                    return 1;
                else
                    return 0;
            }
        }

        mylist.stream().filter(word -> word.charAt(0) > '9')
            .sorted(new StringComparator()).forEach(System.out::println);
        */
    }
}
