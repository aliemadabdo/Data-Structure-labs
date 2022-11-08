import java.util.*;

interface IPlayersFinder {

    public void printInt1DArray(int[] printArray);
    public void printInt2DArray(int[][] printArray,int rows,int columns);
    public void printChar2DArray(char[][] printArray,int rows,int columns);
    public void DFS_to_calc_center (int[][] arrrayIndecator, int x, int y,int rows, int columns, int[] neededPointes);
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
                                
        // System.out.println(" "); 
        // System.out.printf("for elemnt of index x=%d and y=%d ", x , y); 
        // System.out.println(" "); 

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

            // System.out.println("points in if "); 
            // new PlayersFinder().printInt1DArray(neededPointes);

            DFS_to_calc_center(arrrayIndecator, x+1, y  , rows, columns, neededPointes);
            DFS_to_calc_center(arrrayIndecator, x-1, y  , rows, columns, neededPointes);
            DFS_to_calc_center(arrrayIndecator, x  , y+1, rows, columns, neededPointes);
            DFS_to_calc_center(arrrayIndecator, x  , y-1, rows, columns, neededPointes);

            // System.out.printf("done checking all adjacents for point x=%d , y=%d",x,y);
            // System.out.println("");
        }

        // System.out.println("points out if "); 
        // new PlayersFinder().printInt1DArray(neededPointes);
        
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);                    //open scanner

        String dim = sc.nextLine();
        String[] sos = dim.split(", ");     
       
        int rows = Integer.parseInt(sos[0]);
        int columns = Integer.parseInt(sos[1]);
        
        String[] Sphoto = new String[columns];                  //input the photo
        for (int i=0 ; i<rows ; i++){
            Sphoto[i] = sc.nextLine();
        }

        // System.out.println("");
        // System.out.println("photo 1d values:");
        // for (int i=0 ; i<rows ; i++){                   //debug
        //     System.out.println(Sphoto[i]);
        // }

        char threshold = sc.next().charAt(0);
        int minArea = sc.nextInt();

        //System.out.println(rows + " " + columns + " " + threshold + " " + minArea);  //debug
        
        sc.close();             
//====================================input done===============================
        String s = "";
        for (String n:Sphoto)
            s+= n;
        char[] Cphoto = s.toCharArray();  //convert string array to array of charactars 1D
       
        // System.out.println("");
        // System.out.println("S value:");
        // System.out.println(s);

        int c=0;
        int[][] arrrayIndecator = new int[rows][columns]; 
        int[][] backupIndecators = new int[rows][columns]; 
        char[][] char2DPhoto = new char[rows][columns] ;

        // System.out.println("");
        // System.out.println("TH:");
        // System.out.println(threshold);

        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                char2DPhoto[i][j]=Cphoto[c];            // crreating 2d photo of characters
                if (char2DPhoto[i][j] == threshold) // crreating indecator array
                    arrrayIndecator[i][j] = 1; 
                    backupIndecators[i][j] = 1;
                c++;
            }
        }
        // new PlayersFinder().printChar2DArray(char2DPhoto, rows, columns);
        // new PlayersFinder().printInt2DArray(arrrayIndecator, rows, columns);
//====================================preparation done======================================

 
        ArrayList<ArrayList<Integer>> centers = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){         
                if (arrrayIndecator[i][j] == 1){
                    
                    int neededPointes[]={0,i,i,j,j,i,j,minArea};
                     //{counter,x max, x min, y max, y min, x center, y center,minimum area}
                    new PlayersFinder().DFS_to_calc_center(arrrayIndecator,  i, j,rows,columns,neededPointes);
                    if (neededPointes[0]*4>=neededPointes[7]){
                         centers.add( new ArrayList<Integer>(Arrays.asList(neededPointes[6],neededPointes[5])));
                    }
                }         
            }
        }
//====================================logic done======================================

        Collections.sort(centers, new Comparator<ArrayList<Integer>>() {    
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }               
        });
        System.out.printf("[");
        for(int i = 0; i < centers.size(); i++){
                System.out.printf("(%d, %d)",centers.get(i).get(0),centers.get(i).get(1));
                if(i != centers.size() - 1)
                     System.out.print(", ");
        }
        System.out.printf("]");
 
//====================================output done======================================



    }
}

   
