import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public int[] moveValue(int[] array, int value) {
    	
        int k = 0;
        int l = array.length;
        for(int i=0; i<l; i++){
            if(array[i]!=value){
                array[k++] = array[i];
            }
        }
        while(k<l){
            array[k++] = value;
        }
        return array;
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");;
        int[] arr = new int[s.length];
        if (s.length == 1 && s[0].isEmpty())
            arr = new int[]{};
        else {
            for(int i = 0; i < s.length; ++i)
               arr[i] = Integer.parseInt(s[i]);
        }
        int v = sc.nextInt();
        
        int[] res = new Solution().moveValue(arr, v);
        System.out.print("[");
          for(int i = 0; i < arr.length; ++i) {
            System.out.print(res[i]);
            if(i != s.length - 1)
              System.out.print(", ");
        }
        System.out.print("]");
          
          
        
    }
}
