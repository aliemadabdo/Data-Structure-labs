import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.awt.*;


interface IPlayersFinder {

    int xMax = 0, xMin=0, yMax=0, yMin=0;

    public void printInt2DArray(int[][] printArray,int rows,int columns);
    public void printChar2DArray(char[][] printArray,int rows,int columns);
    public Point calcCenter (int[][] arrrayIndecator, int x, int y,int minArea, int rows, int columns, int pointIndex);
}


public class PlayersFinder implements IPlayersFinder{
    int xMax = 0, xMin=0, yMax=0, yMin=0;
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
   
    public Point calcCenter (int[][] arrrayIndecator, int x, int y, int minArea, int rows, int columns, int pointIndex){
                                        //here is a place of any threshold
        Point temp = new Point(); 
        Point center = new Point();
        //center.setLocation(x, y); 

        System.out.println(" "); 
        System.out.printf("for elemnt of index x=%d and y=%d ", x , y); 
        System.out.println(" "); 

        if (arrrayIndecator[x][y] == 1){ 
                                //here is a place for threshold which are not done checking on it 
            arrrayIndecator[x][y] = 0;                  //checked
            // pointIndex++;

           // System.out.println("point index " + pointIndex); 

            if (x<rows-1)
                if (arrrayIndecator[x+1][y] == 1){
                    // System.out.println("x: "+ (x+1));
                    // System.out.println("y: " + y);
                     pointIndex++; 
                    temp = new PlayersFinder().calcCenter(arrrayIndecator, x+1, y, minArea, rows, columns, pointIndex+1);
                    if ((x+1)>xMax){
                        xMax = x+1;
                    }
                    System.out.println("x max: " + xMax); 
                    System.out.println("x max number in the player: " + pointIndex); 
                }
            if (x>0)        
                if (arrrayIndecator[x-1][y] == 1){
                    // System.out.println("x:" + (x-1) );
                    // System.out.println("y:" + y);
                    // pointIndex++; 
                    temp = new PlayersFinder().calcCenter(arrrayIndecator, x-1, y, minArea, rows, columns, pointIndex+1);
                    if ((x-1)<xMin){
                        xMin=x-1;
                        
                    }
                    System.out.println("x min: " + xMin); 
                    System.out.println("x min number in the player: " + pointIndex); 
                }
            if (y<columns-1)
                if (arrrayIndecator[x][y+1] == 1){
                    // System.out.println("x:"+ x);
                    // System.out.println("y:" + (y+1));
                    // pointIndex++; 
                    temp = new PlayersFinder().calcCenter(arrrayIndecator,x,y+1,minArea, rows, columns, pointIndex+1);
                    if ((y-1)<yMin){
                        yMin=y-1;
                        
                    }
                    System.out.println("y min :" + yMin); 
                    System.out.println("y min number in the player: " + pointIndex); 
                }
            if (y>0)
                if (arrrayIndecator[x][y-1] == 1){
                    // System.out.println("x:"+ x);
                    // System.out.println("y:" + (y-1));
                    // pointIndex++; 
                    temp = new PlayersFinder().calcCenter(arrrayIndecator,x,y-1,minArea, rows, columns, pointIndex+1);
                    if ((y+1)>yMax){
                        yMax =y+1;
                    
                    }
                    System.out.println("y max :" + yMax); 
                    System.out.println("y max number in the player: " + pointIndex); 
                }

            //   System.out.println("temp in the function:" + temp);
            System.out.printf("done checking all adjacents for point x=%d , y=%d",x,y);
            System.out.println("");
            System.out.printf("and this is the pixile number %d in the current player:" , pointIndex);
           
            // // System.out.println(" all centers array" + pointIndex); 
            // System.out.println("all temp :");
            // for(int i=0; i<pointIndex; i++){
            //     System.out.print(temp[i]+" ");
            // }
            // System.out.println("");

        }
        System.out.println("");
        System.out.printf("This pixile x=%d y=%d it self is done checking",x,y );
        System.out.println("");
        // System.out.println("temp we collected :");
        // for(int i=0; i<pointIndex; i++){
        //     System.out.print(temp[i]+" ");
        // }
        // System.out.println("");
        System.out.printf("xmax=%d xmin=%d ymax=%d ymin=%d",xMax,xMin,yMax,yMin );
        System.out.println("");
        System.out.println("point index variable to succes the condition :" + pointIndex); 
        if ( (pointIndex*4) < minArea ){
            return null;
        }
        else {
            center.setLocation((xMax-xMin+1), (yMax-yMin+1)); 
            System.out.println("center befor return:" + center); 
        }
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
        int pointIndex=1;
        Point[] temp = new Point[50];          //array of type Point
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){         
                if (arrrayIndecator[i][j] == 1){
                    System.out.println(""); System.out.println(""); System.out.println("");
                    System.out.printf("This is call number %d at ",c );
                    System.out.printf("start point x=%d , y=%d",i,j);

                    temp[c] = new PlayersFinder().calcCenter(arrrayIndecator, i, j, threshold, rows, columns, pointIndex);  
                }   
                        
                c++;        
            }
        }
        System.out.println(""); System.out.println(""); System.out.println("");
        System.out.println("Here we end getting centers and prepare to print");
        System.out.println("the desired output of centers :");
        for(int i=0; i<c; i++){
            System.out.print(temp[i]+" ");
        }
        System.out.println("");

      //  Arrays.sort(temp);
      //  System.out.println(temp);

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
   
