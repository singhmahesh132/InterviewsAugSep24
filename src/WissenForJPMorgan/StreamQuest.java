package WissenForJPMorgan;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
Write a stream function to count the frequency of each letter in the following string -
"a quick brown fox jumped over the lazy dog"
 */

public class StreamQuest {

    public static void main(String[] args){
        String s = "a quick brown fox jumped over the lazy dog";
        Arrays.stream(s.split("")).filter(s1 -> !s1.equals(" "))
                .collect(Collectors.groupingBy(String::valueOf, Collectors.counting()))
                .entrySet().stream().sorted((o1,o2) -> o2.getValue().compareTo(o1.getValue())).forEach(System.out::println);
    }
}
