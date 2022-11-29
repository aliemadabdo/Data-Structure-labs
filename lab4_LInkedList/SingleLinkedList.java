import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import javax.xml.transform.Source;

interface ILinkedList {

public void        add      (Object element                    ); 
public void        add      (int    index    ,  Object element );
public Object      get      (int    index                      );
public void        set      (int    index    ,  Object element );
public void        clear    (                                  );
public boolean     isEmpty  (                                  );
public void        remove   (int    index                      );
public int         size     (                                  );
public ILinkedList sublist  (int    fromIndex , int    toIndex );
public boolean     contains (Object o                          );
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

    public void add(int index, Object element){
        Node tempNode = head;               //we didnt loop with head to remain it at the start
        Node afterNode = new Node();
        Node node = new Node();
        node.element=element;
        
        int i = 0;
        if (index==0){
            head = node;
            node.nextNode=tempNode;
        }
        else {
            while(i<index-1) {
                tempNode = tempNode.nextNode;
                i++;
            }
            afterNode = tempNode.nextNode;
            tempNode.nextNode = node;
            node.nextNode = afterNode;
        }
        size++;
    }

    public Object get(int index){
        Node tempNode = head;               
        int i = 0;
            while(i<index) {
                tempNode = tempNode.nextNode;
                i++;
            }
        return tempNode.element;
    }

    public void set(int index, Object element){
        Node tempNode = head;
        int i = 0;
        while(i<index) {
            tempNode = tempNode.nextNode;
            i++;
        }
        tempNode.element = element;
    }

    public void clear(){
        head = null;
        size = 0;
    }

    public boolean isEmpty(){
        if (head==null)
            return true;
        else 
        return false;
    }

    public void remove (int index){
        Node tempNode = head;
        int i = 0;
        if (index == 0)
            head = tempNode.nextNode;
        else{
            while(i<index-1) {
                tempNode = tempNode.nextNode;
                i++;
            }
            tempNode.nextNode=tempNode.nextNode.nextNode;
        }
        size--;
    }

    public int size(){
        return size;
    }

    public ILinkedList sublist(int fromIndex, int toIndex){
        // Node subHead;
        SingleLinkedList  mySubSingleLinkedList  = new SingleLinkedList();
        Node tempNode = head;
        
        int i = 0;
        while(i<fromIndex){
            tempNode = tempNode.nextNode;
            i++;
        }
        head = tempNode;
        while(i<toIndex){
            mySubSingleLinkedList.add(tempNode);
            tempNode = tempNode.nextNode;
            i++;  
        }
        tempNode.nextNode=null;
        return mySubSingleLinkedList;
    }

    public boolean contains(Object o){
        boolean flag = false;
        Node tempNode = head;
        for (int i=0;i<size;i++){
            if (tempNode.element==o){
                flag=true;
                //break;
            }
            tempNode = tempNode.nextNode;
        }
        return flag;
    }

    public void printTorF(boolean state){
        if (state == true)
            System.out.print("True");
        else if (state == false)
        System.out.print("False");
    }

    public void printSinglell (){
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

    // public void printInterface (ILinkedList mySubSingleLinkedList){
    //     int i =0;

    //     if (head==null){
    //         System.out.print("[]");
    //     }
    //     else {
    //         Node tempNode = head;               //we didnt loop with head to remain it at the start

    //         System.out.print("[");
    //         while(tempNode.nextNode!=null) {
    //             System.out.print(tempNode.element);
    //             if (i<size)
    //                 System.out.print(", ");
    //             tempNode = tempNode.nextNode;
    //             i++;
    //         }
    //         System.out.print(tempNode.element);
    //         System.out.print("]");
    //     }
    // }

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
                mySingleLinkedList.printSinglell(); 
            break;

            case "addToIndex" :
                index = Integer.parseInt(sc.nextLine());
                element = Integer.parseInt(sc.nextLine());
                if (index<0 | index>=mySingleLinkedList.size)
                    System.out.print("Error");
                else {
                    mySingleLinkedList.add(index, element); 
                    mySingleLinkedList.printSinglell();
                }
            break;

            case "get"        :
                index = Integer.parseInt(sc.nextLine()); 
                if (index<0 | index>=mySingleLinkedList.size)
                    System.out.print("Error");
                else 
                    System.out.print(mySingleLinkedList.get(index)); 
            break;

            case "set"        : 
                index = Integer.parseInt(sc.nextLine());
                element = Integer.parseInt(sc.nextLine());
                if (index<0 | index>=mySingleLinkedList.size)
                    System.out.print("Error");
                else {
                    mySingleLinkedList.set(index, element); 
                    mySingleLinkedList.printSinglell();
                }
            break;

            case "clear"      : 
                mySingleLinkedList.clear(); 
                mySingleLinkedList.printSinglell(); 
            break;

            case "isEmpty"    :
                mySingleLinkedList.printTorF(mySingleLinkedList.isEmpty()); 
            break;

            case "remove"     :
                index = Integer.parseInt(sc.nextLine()); 
                if (index<0 | index>=mySingleLinkedList.size)
                    System.out.print("Error");
                else {
                    mySingleLinkedList.remove(index); 
                    mySingleLinkedList.printSinglell(); 
                }
            break;

            case "size"       : 
                System.out.print(mySingleLinkedList.size()); 
            break;

            case "sublist"    :
                fromIndex = Integer.parseInt(sc.nextLine());
                toIndex = Integer.parseInt(sc.nextLine());
                if ( fromIndex>toIndex | fromIndex<0 | toIndex>=mySingleLinkedList.size )
                    System.out.print("Error");
                else {
                    mySingleLinkedList.sublist(fromIndex, toIndex); 
                    mySingleLinkedList.printSinglell(); 
                }
            break;

            case "contains"   : 
                element = Integer.parseInt(sc.nextLine());
                mySingleLinkedList.printTorF(mySingleLinkedList.contains(element));  
            break;
        }
        //sc.close();
    }
}

