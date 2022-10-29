import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public static int fibonacci(int n) {
    	if(n <= 1){
            return 0;
        }else if(n == 2){
            return 1;
        }else{
        return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int op = fibonacci(n);
        System.out.println(op);
        
    }
}
