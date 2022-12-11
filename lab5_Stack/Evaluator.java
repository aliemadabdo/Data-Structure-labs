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
    
public int GetOperatorWeight(char op);

public Boolean checkHigherPrecedence(char operator1, char operator2);

public Boolean IsOperator(char C);

public Boolean IsOperand(char C);

public String infixToPostfix(String expression);  

// /**
// * Evaluate a postfix numeric expression, with a single space separator
// * @param expression postfix expression
// * @return the expression evaluated value
// */

// public int evaluate(String expression);

}

public class Evaluator implements IExpressionEvaluator {

    public int GetOperatorWeight(char op){
        int weight = 0;
        switch (op)
        {
        // case ')':
        //     weight = 1;
        case '+': case '-':
            weight = 2;
        case '*': case '/':
            weight = 3;
        case '^':
            weight = 4;
        // case '(':
        //     weight = 5;
        }
        return weight;
    }
    
    public Boolean checkHigherPrecedence(char operator1, char operator2){
        int op1Weight = GetOperatorWeight(operator1);
        int op2Weight = GetOperatorWeight(operator2);

        return op1Weight > op2Weight ? true : false;
    }
        
    public Boolean IsOperand(char C){
            if (C == 'a' || C == 'b' || C == 'c') 
                return true;
            else
                return false;
    }

    public Boolean IsOperator(char C){
        if (C == '+' || C == '-' || C == '*' || C == '/' || C == '^')
            return true;
        else
            return false;
        }

    public String infixToPostfix(String expression){
        MyStack theStack = new MyStack();
        char[] INPChar = expression.toCharArray();
        char[] copyOfINPChar = new char[INPChar.length];
        // String[] INPChar = new String[] {expression};  
        // String[] copyOfINPChar = new String[] {expression};  
        int k = 0;

        // System.out.println("11");
        for (int i=0; i<INPChar.length;i++){

            if(INPChar[i]=='-' && INPChar[i]==INPChar[i+1]){
                if(i==0 || INPChar[i-1]=='(')
                    i=i+2;
                else{
                    INPChar[i+1]='+';
                    i++;
                }
            }

            //if you are a number
            // System.out.println("22");
            if(IsOperand(INPChar[i])){
                copyOfINPChar[k]=INPChar[i];
                k++;
                // System.out.println("1");
            }
            
            //if you are an operante (not the first one)
            else if (IsOperator(INPChar[i]) && !(theStack.myStack.isEmpty() || checkHigherPrecedence(INPChar[i], (char)theStack.peek()))){
                // System.out.println("hhhhhhh");
                
                
                    copyOfINPChar[k]= (char)theStack.pop();
                    theStack.push(INPChar[i]);
                    k++;
                
                
            }
            else{
                if (INPChar[i]==')'){
                    // System.out.println("55555555");
                    //theStack.pop();
                    while (!theStack.myStack.isEmpty() && (char)theStack.peek()!='('){
                        copyOfINPChar[k]= (char)theStack.pop();
                        k++;
                    }
                    theStack.pop();
                }
                else
                    theStack.push(INPChar[i]);
            }
               
        }
        
        while (!theStack.myStack.isEmpty()){
            copyOfINPChar[k]= (char)theStack.pop();
            k++;
            // System.out.println("33");

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
        System.out.println("48");
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
    }
}