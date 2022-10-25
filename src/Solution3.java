import java.util.*;

public class Solution3 {
    public int[] getInputInt(){
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
        sc.close();    
        return arr;
    }

	public int[] sumEvenOdd(int[] array){
        int evenSum=0,oddSum=0;
        for (int i=0; i<array.length; i++){
            if (array[i]%2==0)  evenSum+=array[i];
               
            else oddSum+=array[i];      
        }
        int[] res = {evenSum, oddSum};
        return res;
    }
	public static void main(String[] args) {
        int[] array = new Solution3().getInputInt();
      	int[] result = new Solution3().sumEvenOdd(array);
        System.out.print("[" + result[0] + ", " + result[1] + "]");
    }
}
