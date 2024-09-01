package AccoliteForMs;

public class DiamondPattern {

    public static void main(String[] args) {
        int num =11;
        int mid = num/2;
        int inc = 0;
        //Running outer loop for num times
        for (int i = 0; i < num; i++) {

            //running inner loop for num times
            for(int j = 0; j < num; j++){

                //If j is in between mid-inc and mid+inc then printing 0
                if(j>=mid-inc && j<=mid+inc)
                    System.out.print("0");
                else
                    System.out.print("1");
            }
            //For half loop inc will be incremented unless inc becomes 5
            if(i<num/2){
                inc++;
            }
            //for rest half j will be decremented again to become 0
            else{
                inc--;
            }
            System.out.println();
        }
    }
}
