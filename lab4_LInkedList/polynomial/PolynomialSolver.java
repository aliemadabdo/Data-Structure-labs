package polynomial;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import LinkedLists.SingleLinkedList;

interface IPolynomialSolver {
    void    setPolynomial     (char poly  , int[][] terms );
    // String  print             (char poly                  );
    // void    clearPolynomial   (char poly                  );
    // float   evaluatePolynomial(char poly  , float   value );
    // int[][] add               (char poly1 , char    poly2 );
    // int[][] subtract          (char poly1 , char    poly2 );
    // int[][] multiply          (char poly1 , char    poly2 );
    
}


//abstract data type node 
class Polynomial{
    int coefficient;
    int power;
    Polynomial next;      //recursevily

    // public Node() {
    //     this.element=0;
    // }
}

public class PolynomialSolver implements IPolynomialSolver{

    int size =0;
    Polynomial head;
    PolynomialSolver A = new PolynomialSolver();
    PolynomialSolver B = new PolynomialSolver();
    PolynomialSolver C = new PolynomialSolver();
    PolynomialSolver R = new PolynomialSolver();
    PolynomialSolver myPolynomialSolver = new PolynomialSolver();

    public void setPolynomial(char poly, int[][] terms){
        int i=0;

        switch(poly){
            case 'A' :
                Polynomial A = new Polynomial();
                A.next=null;
                while(i<size){  //get the size from input
                    A.coefficient=terms[0][i]; 
                    A.power=size-i-1;      
                    A=A.next;
                    i++;
                }
            case 'B' :
                Polynomial B = new Polynomial();
                B.next=null;
                while(i<size){  //get the size from input
                    B.coefficient=terms[0][i]; 
                    B.power=size-i-1;      
                    B=B.next;
                    i++;
                }
            case 'C' :
                Polynomial C = new Polynomial();
                C.next=null;
                while(i<size){  //get the size from input
                    C.coefficient=terms[0][i]; 
                    C.power=size-i-1;     
                    C=C.next;
                    i++;
                }
        }
    }
}
class Hamo{
    public static void main(String[] args) {
        SingleLinkedList m = new SingleLinkedList();
        m.size();
        PolynomialSolver myPolynomialSolver = new PolynomialSolver();
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNext()){
            String operation =sc.nextLine();
        
            String sin = sc.nextLine().replaceAll("\\[|\\]", "");
            String[] s = sin.split(", ");
            //To take input array with format : [1,2,3,5]

            char poly = sc.next().charAt(0); //now, determine the desired char  

        
            // if (s.length == 1 && s[0].isEmpty())
            //     myPolynomialSolver = new PolynomialSolver();
            // else {
            //     for(int i = 0; i < s.length; ++i)
            //         myPolynomialSolver.add(Integer.parseInt(s[i])); // this class-Integer-provide many methodes for integer convertion
            // }
                
            // String inputOperation= sc.nextLine();
            // int index, element, fromIndex, toIndex;
        }
    }
}

 // public void add(Object element){

    //     Polynomial A = new Polynomial();
    //     Polynomial.data=element;
    //     Polynomial.nextNode=null;

    //     if (head==null){
    //         head = node;
    //     }
    //     else {
    //         Node tempNode = head;               //we didnt loop with head to remain it at the start
    //         while(tempNode.nextNode!=null) {
    //             tempNode = tempNode.nextNode;
    //         }
    //         tempNode.nextNode = node;
    //     }
    //     size++;
    // }