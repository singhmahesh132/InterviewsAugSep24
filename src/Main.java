import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class Main {
    public static void main(String [] args){
        String word = "maheshsingh";

        char[] wordArr = word.toCharArray();

        int ptr = 1;
        int alphaPtr;
        char currAlpha = wordArr[0];


        while(ptr < wordArr.length){
            alphaPtr  = ptr;
            //Finding the next instance of repeated character
            for(int i = ptr; i < wordArr.length; i++){

                //running loop to shift one character to right.
                if(wordArr[i] == currAlpha) {
                    int swapPtr = i;
                    while(swapPtr>alphaPtr){
                        wordArr[swapPtr] = wordArr[swapPtr-1];
                        swapPtr--;
                    }
                    //at last replacing it with current alphabet
                    wordArr[swapPtr] = currAlpha;
                }
            }
            ptr++;
            if(ptr<wordArr.length)
                currAlpha = wordArr[ptr];
        }
        System.out.println(Arrays.toString(wordArr));

        //Or Using streams
        Arrays.stream(word.split(""))
                .collect(Collectors.groupingBy(alpha -> alpha,LinkedHashMap::new, Collectors.counting()))
                .forEach((key, value) -> {
                    for (int i = 0; i < value; i++) {
                        System.out.print(key);
                    }
                });
    }
}
