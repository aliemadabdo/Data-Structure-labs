
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
public static int[][] transpose(int[][] matrix){
    int size = matrix.length;
    int[][] trans = new int[size][size];
    for(int i=0; i<size; i++) {
        for(int j=0; j<size; j++) {
            trans[i][j] = matrix[j][i];
        }
    }
    return trans;
  }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sin =sc.nextLine().replaceAll("\\[|\\]", "");
        String[] s = sin.split(", ");
        int l = s.length;
        int sq =  (int)Math.sqrt(l);
        int[][] arr = new int[sq][sq];
        if (l == 1 && s[0].isEmpty())
            arr = new int[][]{};
        else {
            int k = 0;                                      
            for(int i=0; i < sq; i++){
                for(int j=0; j < sq; j++){
                    arr[i][j] = Integer.parseInt(s[k++]);
                }                                         
            }         
        }
        
        int[][] res = transpose(arr);
        
        int c=1;
        System.out.print("[[");
        for(int i = 0; i < res.length; i++) {
            for(int j = 0; j < res.length; j++) {
                System.out.print(res[i][j]);
                if( (c % res.length) != 0){
                    System.out.print(", ");
                }
                else if(c != (res.length*res.length)){
                    System.out.print("], [");
                }
                c++;
            }
      }
      System.out.print("]]");    
    }
}
