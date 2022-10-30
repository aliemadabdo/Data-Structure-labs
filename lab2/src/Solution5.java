import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public int[][] getInputInt(){
        Scanner sc = new Scanner(System.in);
        String sIn =sc.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sIn.split(", ");                 //put numbers in the array and split
        int sqrtOfInput =  (int)Math.sqrt(s.length);
		int[][] arr = new int[sqrtOfInput][sqrtOfInput];
        if (s.length == 1 && s[0].isEmpty())
            arr = new int[][]{};
        else {
            int c = 0;                                      //count elements of 2d array
            for(int i = 0; i < sqrtOfInput; ++i){
                for(int j = 0; j < sqrtOfInput; ++j){
                    arr[i][j] = Integer.parseInt(s[c++]); //this class provide many
                }                                         // methodes for integer convertion
            }  	   
        }
        sc.close();    
     //   System.out.println(arr.length);
        return arr;
    }

	public int[][] transpose(int[][] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array.length; j++) {
                if ( i < j){
                    array[i][j] = array[i][j] + array[j][i];
                    array[j][i] = array[i][j] - array[j][i];
                    array[i][j] = array[i][j] - array[j][i];
                }        
            }
        }
    return array;
    }
    
    public void prinArray(int[][] result){
        int c = 1;
        
        // System.out.println(result.length);
       
        System.out.print("[[");
        for(int i = 0; i < result.length; ++i) {
            for(int j = 0; j < result.length; ++j) {
                System.out.print(result[i][j]);
                if( (c % result.length) != 0){
                    System.out.print(", ");
                }
                else if (c != (result.length*result.length)){
                    System.out.print("], [");
                }
                c++;
            }
      }
      System.out.print("]]");
    }
    public static void main(String[] args) {

        int[][] array = new Solution().getInputInt();
        int[][] result = new Solution().transpose(array);
        new Solution().prinArray(result);
    }
}
