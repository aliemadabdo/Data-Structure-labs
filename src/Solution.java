import java.util.*;

public class Solution {
	public int[] reverse(int[] array){
        int[] reversedArray = new int[array.length];
        for(int i=array.length; i>0; i--)
            reversedArray[i-1]=array[array.length-i];
        return reversedArray;
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

        //To take input array with format : [1,2,3,5]
		Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
    	String[] s = sin.split(", ");
        //To take input array with format : [1,2,3,5]

		int[] arr = new int[s.length];
        if (s.length == 1 && s[0].isEmpty())
            arr = new int[]{};
        else {
            for(int i = 0; i < s.length; ++i)
        	   arr[i] = Integer.parseInt(s[i]); //this class provide many methodes for integer convertion
        }
      	int[] res = new Solution().reverse(arr);
        new Solution().printArray(res);
        sc.close();
    }
}
