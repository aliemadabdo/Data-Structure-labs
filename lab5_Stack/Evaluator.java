import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//input sample
// -(a+b)
// a=8
// b=-2
// c=9

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
class MyStack {
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

interface IExpressionEvaluator {

// public String getInput();
/**
* Takes a symbolic/numeric infix expression as input and converts it to
* postfix notation. There is no assumption on spaces between terms or the
* length of the term (e.g., two digits symbolic or numeric term)
*
* @param expression infix expression
* @return postfix expression
*/
  
public String infixToPostfix(String expression);  

// /**
// * Evaluate a postfix numeric expression, with a single space separator
// * @param expression postfix expression
// * @return the expression evaluated value
// */

// public int evaluate(String expression);

}

public class Evaluator implements IExpressionEvaluator {

    public String infixToPostfix(String expression){
        MyStack theStack = new MyStack();
        char[] INPChar = expression.toCharArray();
        char[] copyOfINPChar = new char[INPChar.length];
        int k = 0;

        for (int i=0; i<INPChar.length;i++){
            if(INPChar[i]!='-' && INPChar[i]!='+' && INPChar[i]!='*' && INPChar[i]!='/' && 
               INPChar[i]!='(' && INPChar[i]!=')' && INPChar[i]!='^'){
                copyOfINPChar[k]=INPChar[i];
                k++;
               }
            else if(theStack.peek()!=null){
                if (theStack.peek()==")"){
                    while(theStack.peek()!="("){
                        copyOfINPChar[k]= (char)theStack.pop();
                        k++;
                    }
                        
                }
                else if((INPChar[i]=='-' || INPChar[i]=='+') && (theStack.peek()=="-" || theStack.peek()=="+" ||
                theStack.peek()=="*" || theStack.peek()=="/" || theStack.peek()=="^" )){
                    copyOfINPChar[k]= (char)theStack.pop();
                    k++;
                }
                else if((INPChar[i]=='*' || INPChar[i]=='/') && (theStack.peek()=="*" || 
                theStack.peek()=="/" || theStack.peek()=="^" )){
                    copyOfINPChar[i]= (char)theStack.pop();
                    k++;

                }
                else if(INPChar[i]=='^' && theStack.peek()=="^") {
                    copyOfINPChar[i]= (char)theStack.pop();
                    k++;

                }
                theStack.push(INPChar[i]);
            }
        }
        while (!theStack.myStack.isEmpty()){
            copyOfINPChar[k]= (char)theStack.pop();
            k++;
        }

        String str = String. valueOf(copyOfINPChar);
        return str;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input   = sc.nextLine();
        String stringA = sc.nextLine();
        String stringB = sc.nextLine();
        String stringC = sc.nextLine();
        
        Evaluator myEvaluator = new Evaluator(); //due to we cannot make a static reference to the non-static method
                                                //so we created an object of the class and call the function from it
        System.out.println(myEvaluator.infixToPostfix(input));
        

        // System.out.println(input);
        // System.out.println(stringA);
        // System.out.println(stringB);
        // System.out.println(stringC);
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
    }
}