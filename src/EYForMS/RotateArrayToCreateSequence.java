package EYForMS;

import java.util.List;

/*Given a list, calculate how many rotations will be required to bring the list into sequence.
list = [4,5,6,7,1,2,3]
output : 3
 */
public class RotateArrayToCreateSequence {
    public static void main(String[] args){
        List<Integer> list = List.of(4,5,6,7,1,2,3);

        int counter = 0;
        boolean rotFlag = false;
        int curNum = list.get(1);

        for(int i = 2; i < list.size(); i++){
            if(rotFlag)
                counter++;
            if(curNum < list.get(i))
                curNum = list.get(i);
            else{
                rotFlag = true;
                counter++;
                curNum = list.get(i);
            }
        }

        System.out.print(counter);
    }
}
