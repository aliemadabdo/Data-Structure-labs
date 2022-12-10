import java.util.*;

class Node{
  Object element;
  Node nextNode;      //recursevily

  // public Node() {
  //     this.element=0;
  // }
}

 class SingleLinkedList {

  public int size = 0;
  public Node head;

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

}

interface IStack {
  
  /*** Removes the element at the top of stack and returnsthat element.
  * @return top of stack element, or through exception if empty
  */
  
  public Object pop();
  
  /*** Get the element at the top of stack without removing it from stack.
  * @return top of stack element, or through exception if empty
  */
  
  public Object peek();
  
  /*** Pushes an item onto the top of this stack.
  * @param object to insert*
  */
  
  public void push(Object element);
  
  /*** Tests if this stack is empty
  * @return true if stack empty
  */
  // public boolean isEmpty();
  
  // public int size();
}
public class MyStack implements IStack {
  SingleLinkedList myStack = new SingleLinkedList();

  public void push(Object element){   //push element to stack
    myStack.add(0, element);
  } //then print stack after push

  public Object pop(){      //return the pushed element
    Object poppedElement = myStack.get(0);
    myStack.remove(0);
    return poppedElement;
  } //print stack after pop

  public Object peek(){     //return the top of the stack
    return myStack.get(0);
  } //print the top element
}

 class haha{ 
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String sin = sc.nextLine().replaceAll("\\[|\\]", "");
    	  String[] s = sin.split(", ");

        MyStack mineStack = new MyStack();
        if (s.length == 1 && s[0].isEmpty())
            mineStack = new MyStack();
        else {
            for(int i = 0; i < s.length; ++i)
            mineStack.myStack.add(Integer.parseInt(s[i])); // this class-Integer-provide many methodes for integer convertion
        }
        
       // mineStack.myStack.printSinglell();


        String inputOperation= sc.nextLine();
        int element;

        switch(inputOperation){

            case "push" :
                element = Integer.parseInt(sc.nextLine());
                    mineStack.push(element); 
                    mineStack.myStack.printSinglell();
            break;

            case "pop"        :
            if (mineStack.myStack.size==0)
              System.out.print("Error");
            else {
              mineStack.pop();
              mineStack.myStack.printSinglell();
            }   
            break;

            case "peek"        :
              if (mineStack.myStack.size==0)
                System.out.print("Error");
              else {
                System.out.print(mineStack.peek()); 
              }  
            break;

            case "isEmpty"    :
                mineStack.myStack.printTorF(mineStack.myStack.isEmpty()); 
            break;

            case "size"       : 
                System.out.print(mineStack.myStack.size()); 
            break;
        }
    }
}