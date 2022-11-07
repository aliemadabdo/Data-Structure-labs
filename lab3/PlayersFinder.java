import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


interface IPlayersFinder {
    public void printInt2DArray(int[][] printArray,int rows,int columns);
    public void printChar2DArray(char[][] printArray,int rows,int columns);
    public java.awt.Point calcCenter (int[][] arrrayIndecator, int x, int y,int minArea, int rows, int columns);
}


public class PlayersFinder implements IPlayersFinder{

    public void printInt2DArray(int[][] printArray,int rows,int columns){
        System.out.println("");
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                System.out.print(printArray[i][j]+" ");
            }
            System.out.println("");
        }

    }
    public void printChar2DArray(char[][] printArray,int rows,int columns){
        System.out.println("");
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                System.out.print(printArray[i][j]+" ");
            }
            System.out.println("");
        }

    }
   
    public java.awt.Point calcCenter (int[][] arrrayIndecator, int x, int y, int minArea, int rows, int columns){
       
        int xMax = 0, xMin=0, yMax=0, yMin=0,pointIndex=0,numOfPixiles=0;
        java.awt.Point[] centers = new java.awt.Point[10000]; 
        java.awt.Point center = new java.awt.Point();
        center.setLocation(1, 1); 

        System.out.println(" "); 
        System.out.printf("for elemnt of index x=%d and y=%d ", x , y); 
        System.out.println(" "); 

        if (arrrayIndecator[x][y] == 1){ 

            arrrayIndecator[x][y] = 0;                  //checked
            numOfPixiles++;

           // System.out.println("point index " + pointIndex); 

            if (x<rows-1)
                if (arrrayIndecator[x+1][y] == 1){
                    System.out.println("x:"+ (x+1));
                    System.out.println("y:" + y);
                    
                    centers[pointIndex] = new PlayersFinder().calcCenter(arrrayIndecator,x+1,y,minArea, rows, columns);
                    if ((x+1)>xMax){
                        xMax =x+1;
                        pointIndex++; 
                    }
                    System.out.println("x max " + xMax); 
                    System.out.println("point index " + pointIndex); 
                }
            if (x>0)
                if (arrrayIndecator[x-1][y] == 1){
                    System.out.println("x:" + (x-1) );
                    System.out.println("y:" + y);
                    centers[pointIndex] = new PlayersFinder().calcCenter(arrrayIndecator,x-1,y,minArea, rows, columns);
                    if ((x-1)<xMin){
                        xMin=x-1;
                        pointIndex++; 
                    }
                    System.out.println("x min " + xMin); 
                    System.out.println("point index " + pointIndex); 
                }
            if (y<columns-1)
                if (arrrayIndecator[x][y+1] == 1){
                    System.out.println("x:"+ x);
                    System.out.println("y:" + (y+1));
                    centers[pointIndex] = new PlayersFinder().calcCenter(arrrayIndecator,x,y+1,minArea, rows, columns);
                    if ((y-1)<yMin){
                        yMin=y-1;
                        pointIndex++; 
                    }
                    System.out.println("y min " + yMin); 
                    System.out.println("point index " + pointIndex); 
                }
            if (y>0)
                if (arrrayIndecator[x][y-1] == 1){
                    System.out.println("x:"+ x);
                    System.out.println("y:" + (y-1));
                    centers[pointIndex] = new PlayersFinder().calcCenter(arrrayIndecator,x,y-1,minArea, rows, columns);
                    if ((y+1)>yMax){
                        yMax =y+1;
                        pointIndex++; 
                    }
                    System.out.println("y max " + yMax); 
                    System.out.println("point index " + pointIndex); 
                }

         //   System.out.println("centers in the function:" + centers);
           
        System.out.println("number of pixiles :" + numOfPixiles);
        if ( (numOfPixiles*4) >= minArea ){
            center.setLocation((xMax-xMin+1), (yMax-yMin+1)); 
            System.out.println("this is a player");
        }
           
        System.out.println("center 1,2,3... in the function:" + center);  
            
            System.out.println("final centers :");
        for(int i=0; i<pointIndex; i++){
            System.out.print(centers[i]+" ");
        }
        System.out.println("");

        }

        System.out.println("final centers :");
        for(int i=0; i<pointIndex; i++){
            System.out.print(centers[i]+" ");
        }
        System.out.println("");

        System.out.println("center befor return direct in the function:" + center);
        return center;
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);                    //open scanner

        int rows =  sc.nextInt();
        int columns = sc.nextInt();

        sc.nextLine();                                           //wait for new line input without 'enter key'
        String[] Sphoto = new String[columns];                  //input the photo
        for (int i=0 ; i<rows ; i++){
            Sphoto[i] = sc.nextLine();
        }

        System.out.println("");
        System.out.println("photo 1d values:");
        for (int i=0 ; i<rows ; i++){                   //debug
            System.out.println(Sphoto[i]);
        }

        char threshold = sc.next().charAt(0);
        int minArea = sc.nextInt();

        System.out.println(rows + " " + columns + " " + threshold + " " + minArea);  //debug
        
        sc.close();


        String s = "";
        for (String n:Sphoto)
            s+= n;
        char[] Cphoto = s.toCharArray();  //convert string array to array of charactars 1D
       
        System.out.println("");
        System.out.println("S value:");
        System.out.println(s);

        int c=0;
        int[][] arrrayIndecator = new int[rows][columns];  
        char[][] char2DPhoto = new char[rows][columns] ;

        System.out.println("");
        System.out.println("TH:");
        System.out.println(threshold);

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                char2DPhoto[i][j]=Cphoto[c];            // crreating 2d photo of characters
                if (char2DPhoto[i][j] == threshold) // crreating indecator array
                    arrrayIndecator[i][j] = 1; 
                
                c++;
            }
        }
        new PlayersFinder().printChar2DArray(char2DPhoto, rows, columns);
        new PlayersFinder().printInt2DArray(arrrayIndecator, rows, columns);
        
        c=0;
        java.awt.Point[] centers = new java.awt.Point[50];          //array of type Point
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){         
                if (arrrayIndecator[i][j] == 1)   
                    centers[c] = new PlayersFinder().calcCenter(arrrayIndecator, i, j, threshold, rows, columns);      
                c++;        
            }
        }
        System.out.println("final centers :");
        for(int i=0; i<c; i++){
            System.out.print(centers[i]+" ");
        }
        System.out.println("");

      //  Arrays.sort(centers);
      //  System.out.println(centers);

    }
}


// //
// 6, 8         rows,cols
// 33JUBU33
// 3U3O4433
// O33P44NB
// PO3NSDP3
// VNDSD333
// OINFD33X
// 3            color
// 16           threshold
// //

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
   
