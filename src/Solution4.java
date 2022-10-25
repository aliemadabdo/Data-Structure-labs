import java.util.*;


public class Solution4 {
    
    // public int[] getInputInt(){
        
    //     return arr;
    // }

	public int[] moveValue(int[] array, int value) {
        int downCounter=1, i=0;
        while(array.length>=downCounter+i+1){   
            if (array[i] == value) {
                //swaping
                array[i] += array[array.length-downCounter];
                array[array.length-downCounter] = array[i] - array[array.length-downCounter];
                array[i] -= array[array.length-downCounter];
                downCounter++;
            }
            if (array[i]!=value)
                i++;
            }
        return array;
    }
   
    public void printArray(int[] result){
        System.out.print("[");
        for(int i = 0; i < result.length; ++i) {
          System.out.print(result[i]);
          if(i != result.length - 1)
            System.out.print(", ");
        }
        System.out.print("]");
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
    	String[] s = sin.split(", ");
        //To take input array with format : [1, 2, 3, 5]

		int[] arr = new int[s.length];
        if (s.length == 1 && s[0].isEmpty())
            arr = new int[]{};
        else {
            for(int i = 0; i < s.length; ++i)
        	   arr[i] = Integer.parseInt(s[i]); //this class provide many methodes for integer convertion
            } 
       // sc.close();
      //  int[] array = new Solution4().getInputInt();  //input array 
        
      Scanner in = new Scanner(System.in);
      String sIn = "2";
      if(in.hasNextLine()){
          sIn = in.nextLine();
        }                 
      int movement = Integer.parseInt(sIn);
      in.close();

        int[] result = new Solution4().moveValue(arr,movement);   //process
        new Solution4().printArray(result);                         //output
    }
}