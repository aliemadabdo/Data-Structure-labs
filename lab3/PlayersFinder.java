import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.awt.*;


interface IPlayersFinder {

    public void printInt1DArray(int[] printArray);
    public void printInt2DArray(int[][] printArray,int rows,int columns);
    public void printChar2DArray(char[][] printArray,int rows,int columns);
    public void DFS_to_calc_center (int[][] arrrayIndecator, int x, int y,int rows, int columns, int[] neededPointes);
    //public int DFS_to_check_area (int[][] arrrayIndecator, int i, int j);
}


public class PlayersFinder implements IPlayersFinder{

    public void printInt1DArray(int[] printArray){
        System.out.println("");
        for(int i=0; i<printArray.length; i++){
                System.out.print(printArray[i]+" ");
        }
    }
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
    public void DFS_to_calc_center (int[][] arrrayIndecator, int x, int y,int rows,int columns,int[] neededPointes){
                                
        System.out.println(" "); 
        System.out.printf("for elemnt of index x=%d and y=%d ", x , y); 
        System.out.println(" "); 

        if ( x < 0 || y < 0 || x > (rows - 1) || y > (columns - 1) || arrrayIndecator[x][y] != 1){
            return;
        }
        if (arrrayIndecator[x][y] == 1){  
            arrrayIndecator[x][y] = 0;                  //checked
            neededPointes[0]++;

            if (x>neededPointes[1]) neededPointes[1]=x;     //x max
            if (x<neededPointes[2]) neededPointes[2]=x;     //x min
            if (y>neededPointes[3]) neededPointes[3]=y;     //y max
            if (y<neededPointes[4]) neededPointes[4]=y;     //y min

            neededPointes[5]=neededPointes[1]+neededPointes[2]+1;   //x center
            neededPointes[6]=neededPointes[3]+neededPointes[4]+1;   //y center

            System.out.println("points in if "); 
            new PlayersFinder().printInt1DArray(neededPointes);

            DFS_to_calc_center(arrrayIndecator, x+1, y  , rows, columns, neededPointes);
            DFS_to_calc_center(arrrayIndecator, x-1, y  , rows, columns, neededPointes);
            DFS_to_calc_center(arrrayIndecator, x  , y+1, rows, columns, neededPointes);
            DFS_to_calc_center(arrrayIndecator, x  , y-1, rows, columns, neededPointes);

            System.out.printf("done checking all adjacents for point x=%d , y=%d",x,y);
            System.out.println("");
        }

        System.out.println("points out if "); 
        new PlayersFinder().printInt1DArray(neededPointes);
        
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);                    //open scanner

        int rows = sc.nextInt();
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
        
        sc.close();             //input done

        String s = "";
        for (String n:Sphoto)
            s+= n;
        char[] Cphoto = s.toCharArray();  //convert string array to array of charactars 1D
       
        System.out.println("");
        System.out.println("S value:");
        System.out.println(s);

        int c=0;
        int[][] arrrayIndecator = new int[rows][columns]; 
        int[][] backupIndecators = new int[rows][columns]; 
        char[][] char2DPhoto = new char[rows][columns] ;

        System.out.println("");
        System.out.println("TH:");
        System.out.println(threshold);

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                char2DPhoto[i][j]=Cphoto[c];            // crreating 2d photo of characters
                if (char2DPhoto[i][j] == threshold) // crreating indecator array
                    arrrayIndecator[i][j] = 1; 
                    backupIndecators[i][j] = 1;
                c++;
            }
        }
        new PlayersFinder().printChar2DArray(char2DPhoto, rows, columns);
        new PlayersFinder().printInt2DArray(arrrayIndecator, rows, columns);
        
        c=0; 
        // Point center = new Point();          //array of type Point
        int[] centers = new int[10]; 
        // ArrayList<List<Integer>> group = new ArrayList<List<Integer>>();
        // group.add(Arrays.asList(1, 2, 3));
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){         
                if (arrrayIndecator[i][j] == 1){

                    int neededPointes[]={0,i,i,j,j,i,j,minArea};
                     //{counter,x max, x min, y max, y min, x center, y center,minimum area}

                    new PlayersFinder().DFS_to_calc_center(arrrayIndecator,  i, j,rows,columns,neededPointes);
                    System.out.println("get center indecators ");
                    new PlayersFinder().printInt2DArray(arrrayIndecator, rows, columns);
                    System.out.println("check area indecators ");
                    new PlayersFinder().printInt2DArray(arrrayIndecator, rows, columns);
                    System.out.printf("after return number %d : ",c+1);
                    new PlayersFinder().printInt1DArray(neededPointes);

                    if (neededPointes[0]*4>=neededPointes[7]){

                        centers[c]=neededPointes[6];
                        centers[c+1]= neededPointes[5];
                        // System.out.println("");
                        // System.out.println("center"+center);
                        c=c+2; 
                    }
                    else{
                        System.out.println("this is not a valid player"); 
                    }
                    System.out.println("centers array");
                    for(int k=0; k<centers.length; k++){
                            System.out.print(centers[k]+" ");
                    }
                }         
            }
        }

        System.out.println(""); System.out.println(""); System.out.println("");
        System.out.println("Here we end getting centers and prepare to print");
        System.out.println("the desired output of centers :");
        for(int i=0; i<c; i++){
            System.out.print(centers[i]+" ");
        }
        System.out.println("");
    }
}


   
