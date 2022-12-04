
// >>>>>>>Modefing tail is needed<<<<<<<<<<<

package LinkedLists;
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
    Node nextNode; 
    Node prevNode; 
               
} 
 
public class DoubleLinkedList implements ILinkedList { 
 
    int size =0; 
    Node head, tail = null; 
 
    public void add(Object element){ 
 
        Node newNode = new Node();
        newNode.element=element; 
        if(head == null){ 
            head = tail = newNode; 
            head.prevNode = null; 
            tail.nextNode = null; 
        } 
        else{ 
            tail.nextNode = newNode; //tail = head+sawp
            newNode.prevNode = tail; 
            tail = newNode; 
            tail.nextNode = null; 
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
        DoubleLinkedList  mySubDoubleLinkedList  = new DoubleLinkedList(); 
        Node tempNode = head; 
         
        int i = 0; 
        while(i<fromIndex){ 
            tempNode = tempNode.nextNode; 
            i++; 
        } 
        head = tempNode; 
        while(i<toIndex){ 
            mySubDoubleLinkedList.add(tempNode); 
            tempNode = tempNode.nextNode; 
            i++;   
        } 
        tempNode.nextNode=null; 
        return mySubDoubleLinkedList; 
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
 
    // public void printInterface (ILinkedList mySubDoubleLinkedList){ 
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
 
        DoubleLinkedList  myDoubleLinkedList  = new DoubleLinkedList(); 
        if (s.length == 1 && s[0].isEmpty()) 
            myDoubleLinkedList = new DoubleLinkedList(); 
        else { 
            for(int i = 0; i < s.length; ++i) 
                myDoubleLinkedList.add(Integer.parseInt(s[i])); // this class-Integer-provide many methodes for integer convertion 
        } 
             
        String inputOperation= sc.nextLine(); 
        int index, element, fromIndex, toIndex; 
 
        switch(inputOperation){ 
            case "add"        :  
                element = Integer.parseInt(sc.nextLine()); 
                myDoubleLinkedList.add(element);  
                myDoubleLinkedList.printSinglell();  
            break; 
 
            case "addToIndex" : 
                index = Integer.parseInt(sc.nextLine()); 
                element = Integer.parseInt(sc.nextLine()); 
                if (index<0 | index>=myDoubleLinkedList.size) 
                    System.out.print("Error"); 
                else { 
                    myDoubleLinkedList.add(index, element);  
                    myDoubleLinkedList.printSinglell(); 
                } 
            break; 
 
            case "get"        : 
                index = Integer.parseInt(sc.nextLine());  
                if (index<0 | index>=myDoubleLinkedList.size) 
                    System.out.print("Error"); 
                else  
                    System.out.print(myDoubleLinkedList.get(index));  
            break; 
 
            case "set"        :  
                index = Integer.parseInt(sc.nextLine()); 
                element = Integer.parseInt(sc.nextLine()); 
                if (index<0 | index>=myDoubleLinkedList.size) 
                    System.out.print("Error"); 
                else { 
                    myDoubleLinkedList.set(index, element);  
                    myDoubleLinkedList.printSinglell(); 
                } 
            break; 
 
            case "clear"      :  
                myDoubleLinkedList.clear();  
                myDoubleLinkedList.printSinglell();  
            break; 
 
            case "isEmpty"

                : 
                myDoubleLinkedList.printTorF(myDoubleLinkedList.isEmpty());  
            break; 
 
            case "remove"     : 
                index = Integer.parseInt(sc.nextLine());  
                if (index<0 | index>=myDoubleLinkedList.size) 
                    System.out.print("Error"); 
                else { 
                    myDoubleLinkedList.remove(index);  
                    myDoubleLinkedList.printSinglell();  
                } 
            break; 
 
            case "size"       :  
                System.out.print(myDoubleLinkedList.size());  
            break; 
 
            case "sublist"    : 
                fromIndex = Integer.parseInt(sc.nextLine()); 
                toIndex = Integer.parseInt(sc.nextLine()); 
                if ( fromIndex>toIndex | fromIndex<0 | toIndex>=myDoubleLinkedList.size ) 
                    System.out.print("Error"); 
                else { 
                    myDoubleLinkedList.sublist(fromIndex, toIndex);  
                    myDoubleLinkedList.printSinglell();  
                } 
            break; 
 
            case "contains"   :  
                element = Integer.parseInt(sc.nextLine()); 
                myDoubleLinkedList.printTorF(myDoubleLinkedList.contains(element));   
            break; 
        } 
        //sc.close(); 
    } 
}
