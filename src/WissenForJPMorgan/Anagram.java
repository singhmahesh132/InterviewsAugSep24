package WissenForJPMorgan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Anagram {
    public static void main(String[] args){
        String s1 = "anagram";
        String s2 = "snramaag";
        boolean flag = true;

        Map<String, Long> s1Map = Arrays.stream(s1.split("")).
                collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));

        Map<String, Long> s2Map = Arrays.stream(s2.split("")).
                collect(Collectors.groupingBy(String::valueOf, Collectors.counting()));

        for (Map.Entry<String,Long> s2Entry : s2Map.entrySet()){
            if(s1Map.containsKey(s2Entry.getKey())) {
                if (s1Map.get(s2Entry.getKey()) != s2Entry.getValue()) {
                    flag = false;
                    break;
                }
            }
            else {
                flag = false;
                break;
            }
        }
        if(flag)
            System.out.println("Is Anagram");
        else
            System.out.println("Not Anagram");

        //Or Other approach
        //Sort the string and then compare them.
        char[] s1CharArray = s1.toCharArray();
        Arrays.sort(s1CharArray);
        String sortedS1 = new String(s1CharArray);

        char[] s2CharArray = s2.toCharArray();
        Arrays.sort(s2CharArray);
        String sorteds2 = new String(s2CharArray);

        if(sortedS1.equals(sorteds2))
            System.out.println("Is Anagram");
        else
            System.out.println("Not Anagram");
    }
}
