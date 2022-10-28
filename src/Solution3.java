import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public int[] sumEvenOdd(int[] array) {
    	/*
        	Implement your method here
        */
        int sumEven = 0;
        int sumOdd  = 0;
        int[] op = new int[2];
        if(array.length == 0){
            op = new int[] {0, 0};
            return op;
        }else{
            for(int i=0; i<array.length; i++){
            if(array[i]%2==0){
                sumEven += array[i];
            }else{
                sumOdd += array[i];    
            }
          } op = new int[] {sumEven, sumOdd};
            return op;
        }
        
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT.            Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");
        int[] arr = new int[s.length];
        if (s.length == 1 && s[0].isEmpty())
            arr = new int[]{};
        else {
            for(int i = 0; i < s.length; ++i)
               arr[i] = Integer.parseInt(s[i]);
        }
        
        int[] result = new Solution().sumEvenOdd(arr);
        System.out.print("[" + result[0] + ", " + result[1] + "]");
         
        
    }
}
