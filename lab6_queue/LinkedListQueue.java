import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

interface ILinkedBased { }

interface IQueue {
  /*** Inserts an item at the queue front.*/
  public void enqueue(Object item);
  /*** Removes the object at the queue rear and returnsit.*/
  public Object dequeue();
  /*** Tests if this queue is empty.*/
  public boolean isEmpty();
  /*** Returns the number of elements in the queue*/
  public int size();
}

public class LinkedListQueue implements IQueue ,ILinkedBased {
  public class Node
    {
      Object data;
      Node next;
    }
    Node top=null;
    Node end=null;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
         int x,p=0;
        Object q=-99;
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        LinkedListQueue queue =new LinkedListQueue();
        Scanner sc=new Scanner(System.in);
        String sin=sc.nextLine();
        if(sin.equals("[]"))
        {
           p=1;
        }
        else{
            String [] s=sin.replaceAll(" ","").replaceAll("\\[","").replaceAll("]","").split(",");
            x=s.length;
            int array[]= new int[s.length]; 
            for(int i=array.length-1;i>=0;i--)
            {
               queue.enqueue(Integer.parseInt(s[i]));
            }
        }
        String key=sc.nextLine();

        if(key.equals("enqueue")){
              Object m;
            m=sc.nextInt();
            queue.enqueue(m);
            queue.display();
        }
        else if(key.equals("dequeue")){
           Object u;
            if(p==0){
            u=queue.dequeue();
            if(u==q){
                System.out.print("Error");
            }
            else{
            queue.display();}}
            else{System.out.print("Error");}
        }   
        else if(key.equals("isEmpty")){
            try{
            boolean c=queue.isEmpty();
            if(c==false){
            System.out.print("False");}
            else{System.out.print("True");}
        }
    catch(Exception e){System.out.print("True");}
    }
        else if(key.equals("size")){
           int r=queue.size();
           System.out.print(r); 
        }
    }
    public void enqueue(Object item){
        Node n=new Node();
        n.data=item;
        if(top==null){
            top=n;
            end=n;
        }
        else{end.next=n;
            end=n;}
    }
    public Object dequeue(){
        try{
         Node n=new Node();
        if(top==null){
            return -99;
        }
        else {
            n=top;
            top=top.next;
        }
        if(top==null){
            end=null;
        }
        return top.data;
    }
        catch(Exception e){return 0;}
    }
     public boolean isEmpty(){
         if(top==null){
             return true;
         }
         else{
             return false;
         }
     }
     public int size(){
        int size=1;
        Node n=new Node();
        n=top;
        if(top==null){
            return 0;
        }
        while(n.next!=null){
            n=n.next;
            size++;
        }
        return size;
     }
    public void display(){
        Object[] array =new Object[100];
    Node n=new Node();
    n=top;
        int k=0;
        while(n!=null){
            array[k]=n.data;
            k++;
            n=n.next;
        }
    System.out.print("[");
        int i=k-1;
        while(i>=0)
        { if(i>0){
            System.out.print(array[i]+", ");}
         else{System.out.print(array[i]);}
        
        i--;}
    System.out.print("]");
}
    
}