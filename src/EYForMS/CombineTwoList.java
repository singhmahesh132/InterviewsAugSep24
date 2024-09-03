package EYForMS;

import java.util.ArrayList;
import java.util.List;

/*
combine two separate sorted list to produce a single sorted list
 */
public class CombineTwoList {
    public static void main(String[] args){
        List<Integer> list1 = List.of(1,2,4);
        List<Integer> list2 = List.of(1,3,4);
        List<Integer> combinedList = new ArrayList<>();

        int totSize = list1.size()+list2.size();
        int ptr1 = 0;
        int ptr2 = 0;

        for(int i = 0; i < totSize ; i++){
            if(ptr1 < list1.size() && ptr2 < list2.size()) {
                if (list1.get(ptr1) <= list2.get(ptr2))
                    combinedList.add(list1.get(ptr1++));
                else
                    combinedList.add(list2.get(ptr2++));
            }
            else if(ptr1 >= list1.size())
                combinedList.add(list2.get(ptr2++));
            else
                combinedList.add(list1.get(ptr1++));
        }

        for (Integer i : combinedList) {
            System.out.print(i+" ");
        }
    }
}
