import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import javax.xml.transform.Source;

interface ILinkedList {

public void        add      (Object element                    ); 
// public void        add      (int    index    ,  Object element );
// public Object      get      (int    index                      );
// public void        set      (int    index    ,  Object element );
// public void        clear    (                                  );
// public boolean     isEmpty  (                                  );
// public void        remove   (int    index                      );
// public int         size     (                                  );
// public ILinkedList sublist  (int    fromIndex , int    toIndex );
// public boolean     contains (Object o                          );
}


//abstract data type node 
class Node{
    Object element;
    Node nextNode;      //recursevily

    // public Node(Object data) {
    //     this.data=data;
    // }
}

public class SingleLinkedList implements ILinkedList {

    int size =0;
    Node head;
    
    // public int data;
    // public SingleLinkedList next;

    // SingleLinkedList(int data){
    //     this.data = data;
    //     this.next = null;
    // }

    public void add(Object element){

        Node node = new Node();
        node.element=element;
        node.nextNode=null;

        if (head==null){
            head = node;
        }
        else {
            Node tempNode = head;               //we didnt loop with head to remain it at the start
            while(tempNode.nextNode!=null) {
                tempNode = tempNode.nextNode;
            }
            tempNode.nextNode = node;
        }
        size++;
    }

    public void printSinglell (SingleLinkedList mySingleLinkedList){
        int i =0;

        if (head==null){
            System.out.print("[]");
        }
        else {
            Node tempNode = head;               //we didnt loop with head to remain it at the start

            System.out.print("[");
            while(tempNode.nextNode!=null) {
                System.out.print(tempNode.element);
                if (i<size)
                    System.out.print(", ");
                tempNode = tempNode.nextNode;
                i++;
            }
            System.out.print(tempNode.element);
            System.out.print("]");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
    	String[] s = sin.split(", ");
        //To take input array with format : [1,2,3,5]

		 SingleLinkedList  mySingleLinkedList  = new SingleLinkedList();
        if (s.length == 1 && s[0].isEmpty())
            mySingleLinkedList = new SingleLinkedList();
        else {
            for(int i = 0; i < s.length; ++i)
                mySingleLinkedList.add(Integer.parseInt(s[i])); // this class-Integer-provide many methodes for integer convertion
        }
            
        String inputOperation= sc.nextLine();
        int index, element, fromIndex, toIndex;

        switch(inputOperation){
            case "add"        : 
                element = Integer.parseInt(sc.nextLine());
                mySingleLinkedList.add(element); 
                mySingleLinkedList.printSinglell(mySingleLinkedList); 
            break;
           
        }
    }
}

