import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


interface IPlayersFinder {
    //public void getInputInt();
  // java.awt.Point[] findPlayers(String[] photo, int team, int threshold);
    /**
     * Search for players locations at the given photo
     * param photo
     *     Two dimension array of photo contents
     *     Will contain between 1 and 50 elements, inclusive
     * param team
     *     Identifier of the team
     * param threshold
     *     Minimum area for an element
     *     Will be between 1 and 10000, inclusive
     * return
     *     Array of players locations of the given team
     */
   
}


public class PlayersFinder implements IPlayersFinder{
	
    // public java.awt.Point[] findPlayers(String[] photo, int team, int threshold){
    //     Point p=20;
    //     return p; 
    // }



    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int rows =  sc.nextInt();
        int columns = sc.nextInt();

        sc.nextLine();   
        String[] Sphoto = new String[columns];
        for (int i=0 ; i<rows ; i++){
            Sphoto[i] = sc.nextLine();
        }
        for (int i=0 ; i<rows ; i++){                   //debug
            System.out.println(Sphoto[i]);
        }

        int threshold = sc.nextInt();
        int minArea = sc.nextInt();

        System.out.println(rows + " " + columns + " " + threshold + " " + minArea);  //debug
        
        sc.close();
        //////////////////////////////// input done//////////////////////////////////////////////

        String s = "";
        for (String n:Sphoto)
            s+= n;
        char[] Cphoto = s.toCharArray();  //convert string array to array of charactars 1D
        System.out.println(s);
        int c=0;
        char[][] char2DPhoto = new char[rows][columns] ;
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                char2DPhoto[i][j]=Cphoto[c];
                c++;
            }
        }
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                System.out.print(char2DPhoto[i][j]+" ");
            }
            System.out.println("");
        }
        
    }
}


//
// 6, 8         rows,cols
// 33JUBU33
// 3U3O4433
// O33P44NB
// PO3NSDP3
// VNDSD333
// OINFD33X
// 3            color
// 16           threshold
//
