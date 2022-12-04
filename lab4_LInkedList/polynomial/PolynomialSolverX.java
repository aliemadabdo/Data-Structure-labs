package polynomial;
import java.rmi.RemoteException;
import java.util.*;
import java.io.IOException;


public class PolynomialSolverX {

    class SingleLinkedList  {
        Entry first;
        Entry last;
        int size = 0;
        public SingleLinkedList(){}


        class Entry
        {
            int coff;
            int pow;
            Entry next;
            //constructor
            Entry(int data,int pow)
            {this.coff = data;
                this.pow=pow;}
        } // class Entry

        public  Entry getObj(int index) {
            {
                Entry e;
                e = first;
                for(int i=index ;i>0 ;i--)
                    e = e.next;
                return e;
            }
        }

        public int get(int index)  {
            return getObj(index).coff;
        }

        public boolean zero(){
            boolean zero=true;
            Entry trav= first;
            while (trav!=null){
                zero=zero&&(trav.coff==0);
                trav=trav.next;
            }
            zero=(zero&&(!this.isEmpty()));
            return zero;
        }



        public void clear() {
            if (size>0){
                first=last=null;
                size=0;
            }
        }

        public boolean isEmpty(){
            return size()==0;
        }

        public int size() {
            return size;
        }


        public void add(int element,int pow) {
            Entry n = new Entry(element,pow);
            if (size==0)
                first=last=n;
            else
            {
                if (last!=null){
                    last.next = n;
                    last = n;}
                else{first=n;}
            }
            size++;
        }

        public void removeDuplicates()
        {
            Entry curr=this.first;
            while (curr != null && curr.next != null) {
                Entry temp = curr;
                while (temp.next != null) {
                    if (curr.pow == temp.next.pow) {
                        curr.coff = curr.coff + temp.next.coff;
                        temp.next = temp.next.next;
                    }
                    else
                        temp = temp.next;
                }
                curr = curr.next;
            }
        }


        /////////////////////////////////////////////////////////


        public void printPoly() {
            Entry trav= this.first;
            if (this.zero()){System.out.println("0");}
            if(trav==null){System.out.print("[]");}
            while (trav != null) {
                if (!(trav.coff==0)){
                    if (! (trav.coff==1))
                    {System.out.print(trav.coff);}
                    if(! (trav.pow==0))
                        System.out.print("x");
                    if(! (trav.pow<2))
                        System.out.print("^");
                    if(!(trav.pow<2))
                        System.out.print(trav.pow);
                    if((trav.next!=null)&&trav.next.coff>0)
                        System.out.print("+");
                }trav = trav.next;
            }
            System.out.println();
        }

    }


    SingleLinkedList polyA =new SingleLinkedList();
    SingleLinkedList polyB =new SingleLinkedList();
    SingleLinkedList polyC =new SingleLinkedList();
    SingleLinkedList R =new SingleLinkedList();

    public SingleLinkedList get(char poly)
    {
        SingleLinkedList ls;
        switch (poly) {
            case 'A' :
                ls= polyA;
                break;
            case 'B':
                ls= polyB;
                break;
            case 'C':
                ls= polyC;
                break;
            default :
                throw new RuntimeException();
        }
        return ls;
    }

    public void setPolynomial(char poly, int[] terms) {
        switch (poly){
            case 'A':
                for (int i=0 ; i<terms.length ; i++)
                    polyA.add(terms[i],terms.length-(i+1));
                break;
            case 'B':
                for (int i=0 ; i<terms.length ; i++)
                    polyB.add(terms[i],terms.length-(i+1));
                break;
            case 'C':
                for (int i=0 ; i<terms.length ; i++)
                    polyC.add(terms[i],terms.length-(i+1));
                break;
            default:throw new RuntimeException();
        }

    }

    public void print(char poly) throws IOException {
        switch (poly) {
            case 'A' :
                polyA.printPoly();
                break;
            case 'B':
                polyB.printPoly();
                break;
            case 'C':
                polyC.printPoly();
                break;
            case 'R':
                R.printPoly();
                break;
            default:
                throw new RuntimeException();

        }

    }


    public  void addPolynomial(SingleLinkedList p1, SingleLinkedList p2,int sign)
    {
        if (p1.first == null || p2.first == null) {
            throw new RuntimeException();
        } else {

            SingleLinkedList.Entry a = p1.first;
            SingleLinkedList.Entry b= p2.first;

            while (a != null || b != null) {

                if (a == null) {
                    R.add(b.coff,sign*b.pow);
                    break;
                }
                else if (b == null) {
                    R.add(a.coff,a.pow);
                    break;
                }

                else if (a.pow == b.pow) {
                    R.add(a.coff + sign*b.coff, a.pow);
                    a = a.next;
                    b = b.next;
                }

                else if (a.pow > b.pow) {
                    R.add(a.coff, a.pow);
                    a = a.next;
                }

                else {
                    R.add(sign*b.coff, sign*b.pow);
                    b = b.next;
                }
            }
        }}



    public float evaluatePolynomial(SingleLinkedList ev , float x)  {
        float result = ev.first.coff;
        int n=ev.size();

        for (int i=1; i<n; i++)
            result = result*x + ev.get(i);

        return result;
    }


    public void multiply(SingleLinkedList p1, SingleLinkedList p2)
    {
        if (p1.first == null || p2.first == null) {
            throw new RuntimeException();
        } else {

            SingleLinkedList.Entry ptr1 = p1.first;
            SingleLinkedList.Entry ptr2= p2.first;

            while (ptr1 != null) {
                while (ptr2 != null) {
                    int coff, power;
                    coff = ptr1.coff * ptr2.coff;
                    power = ptr1.pow + ptr2.pow;
                    R.add(coff, power);
                    ptr2 = ptr2.next;
                }
                ptr2 = p2.first;
                ptr1 = ptr1.next;
            }
            R.removeDuplicates();
        }
    }

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
        PolynomialSolver polysolve=new PolynomialSolver();
        String command;
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
        
            try {
                command =sc.nextLine();
            }
            catch (Exception e){break;}
            try {
                switch (command) {
                    case "set":
                        char toSet = sc.nextLine().charAt(0);
                        if ((toSet!='A') &&(toSet!='B')&&(toSet!='C')){throw new RuntimeException();}

                        else{
                            String sin = sc.nextLine().replaceAll("\\[|\\]", "");
                            String[] s = sin.split(",");
                            int[] ls = new int[s.length];
                            if (s.length == 1 && s[0].isEmpty())
                                throw new RuntimeException();
                            else {
                                for (int i = 0; i < s.length; ++i)
                                    ls[i] = (Integer.parseInt(s[i]));
                            }
                            polysolve.setPolynomial(toSet, ls);
                            break;}

                    case "print":
                        char toPrint = sc.nextLine().charAt(0);
                        polysolve.print(toPrint);
                        break;

                    case "add":
                        char toAddA = sc.nextLine().charAt(0);
                        char toAddB = sc.nextLine().charAt(0);
                        polysolve.addPolynomial(polysolve.get(toAddA), polysolve.get(toAddB), 1);
                        polysolve.print('R');
                        break;

                    case "sub":
                        char toSubA = sc.nextLine().charAt(0);
                        char toSubB = sc.nextLine().charAt(0);
                        polysolve.addPolynomial(polysolve.get(toSubA), polysolve.get(toSubB), -1);
                        polysolve.print('R');
                        break;

                    case "mult":
                        char toMultA = sc.nextLine().charAt(0);
                        char toMultB = sc.nextLine().charAt(0);
                        polysolve.multiply(polysolve.get(toMultA), polysolve.get(toMultB));
                        polysolve.R.printPoly();
                        break;

                    case "clear":
                        char toClr = sc.nextLine().charAt(0);
                        SingleLinkedList clr = polysolve.get(toClr);
                        if (clr.first == null) {
                            throw new RuntimeException();
                        } else {
                            clr.clear();
                            polysolve.get(toClr).printPoly();
                        }

                        break;
                    case "eval":
                        char toEv = sc.nextLine().charAt(0);
                        float x = sc.nextFloat();
                        if (polysolve.get(toEv).isEmpty()) {
                            throw new RuntimeException();
                        } else {
                            float result = polysolve.evaluatePolynomial(polysolve.get(toEv), x);

                            if ((int) result == result) {
                                System.out.println((int) result);
                            } else {
                                System.out.println(result);
                            }
                        }
                        break;
                    default:
                        throw new RuntimeException();
                }
            }catch (Exception e){System.out.println("Error");break;}
        }
    }
}
