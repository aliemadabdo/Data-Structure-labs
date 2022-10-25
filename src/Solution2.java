import java.util.*;

public class Solution2 {
	public double average(int[] array) {
        double sum=0;
        for(int i=0; i<array.length; i++){
            sum += array[i];
        }
        if (array.length==0) return 0;
        else  return sum/array.length;
       
    }
    public static void main(String[] args) {
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
        double arrAverage = new Solution2().average(arr);
        System.out.print(arrAverage);
        sc.close();
    }
}