// In this file i have merged most used algorithms(such as KnapSack,Floyds,Kruskal,MergeSort,Prims Algorithm,Dijiskstra Algorithm) with the option to switch between them 


import java.lang.*;
import java.util.*;
import java.util.Random;
// import myPrgms.studentDetails;


//Start of program No.1 a(Student details program)
class studentDetails {
    String NAME,USN,BRANCH,PHONE;
    void insertRecord(String name,String usn,String br,String ph){
        NAME = name;
        USN = usn;
        BRANCH= br;
        PHONE = ph;
    }
    void displayRecord(){
        System.out.println("\nNAME: "+NAME+"\nUSN : "+USN+"\nBRANCH: "+BRANCH+"\nPHONE : "+PHONE);
    }
}
//End of program No.1 a(Student details program)

//Start of the program No.1 b(Stack Operations)
class stack {
    int top = -1;
    int size = 10, ele;
    int s[] = new int[size];

    void Push() {
        if (top == size - 1) {
            System.out.println("Stack OverFlow! \n");
            return;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Element to be pushed : ");
        ele = sc.nextInt();
        s[++top] = ele;
    }

    void Pop() {
        if (top == -1) {
            System.out.println("Stack UnderFlow!\n");
            return;
        }
        // ele = s[top--];
        System.out.println("The popped Element is " + s[top--]);
    }

    void Display() {
        if (top == -1) {
            System.out.println("Stack Is Empty!\n");
            return;
        }
        System.out.println("The Stack Elements are :");
        for (int i = top; i > -1; i--) {
            System.out.println(s[i]);

        }
    }

    // public static void main(String[] args) {
    // stack st = new stack();
    // Scanner sc = new Scanner(System.in);

    // }

}

// End of the program No.1 b(Stack Operations)

// Start of the program No.2 a(Staff Details)
class AStaff {
    String Name, StaffId, phone, Salary;

    void read() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Staff ID :");
        Name = sc.nextLine();
        System.out.println("Enter Name :");
        StaffId = sc.nextLine();
        System.out.println("Enter Phone No. :");
        phone = sc.nextLine();
        System.out.println("Enter Salary :");
        Salary = sc.nextLine();

    }

    void disp() {
        System.out.println("Staff Details are ");
        System.out.println("\nStaff ID :" + StaffId);
        System.out.println("\nName :" + Name);
        System.out.println("\nPhone No:" + phone);
        System.out.println("\nSalary :" + Salary);

    }

}

class ATeaching extends AStaff {
    String Domain, Publications;

    void read1() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Domain :");
        Domain = sc.nextLine();
        System.out.println("Enter Publiation :");
        Publications = sc.nextLine();
    }

    void disp1() {
        System.out.println("\nDomain:" + Domain);
        System.out.println("\nPublications :" + Publications);

    }

}

class ATechnical extends AStaff {
    String Skill;

    void read2() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Skill :");
        Skill = sc.nextLine();

    }

    void disp2() {
        System.out.println("\nSkills :" + Skill);

    }

}

class AContract extends AStaff {
    String period;

    void read3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter period :");
        period = sc.nextLine();

    }

    void disp3() {
        System.out.println("\nPeriod :" + period);

    }

}


// End of the program No.2 a(Staff Details)



//Start of the program No.2 b(Customer Name and DOB)

class customer {
  void pg2_b(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Customer Name and Date of Birth in the format <NAME,DD-MM-YYYY>: \n");
    String name = sc.next();
    System.out.println();
    StringTokenizer st = new StringTokenizer(name,"-");
    int count = st.countTokens();
    for (int i=0;i<=count && st.hasMoreTokens();i++){
        System.out.print(st.nextToken());
        if(i<count)
            System.out.print("/");
    }
  }
   
}

//End of the program No.2 b(Customer Name and DOB)




// Start of the program No.3 a(Read Compute and print two integers using try and catch block)
class divison {
    void pg3_a(){
        Scanner sc = new Scanner(System.in);
        int a,b,result;
        System.out.println("Enter the value of a : ");
        a = sc.nextInt();
        System.out.println("Enter the value of b : ");
        b = sc.nextInt();
        try{
            result = a/b;
            System.out.println("Result : "+result);
        }catch(ArithmeticException e){
            System.out.println("Exception caught : Divide by zero error."+e);
 
        }
    }
}
// End of the program No.3 a(Read Compute and print two integers using try and catch block)


// Start of the program No.3 b(Multi Threading)

class SquareThread implements Runnable {
    int x;

    SquareThread(int a) {
        this.x = a;
    }

    public void run() {
        System.out.println("Thread Name : Square Thread and Square of " + x + " is " + x * x);
    }
}

class CubeThread implements Runnable {
    int x;

    CubeThread(int a) {
        this.x = a;
    }

    public void run() {
        System.out.println("Thread Name : Cube Thread and Square of " + x + " is " + x * x * x);
    }
}

class RandomThread implements Runnable {
    Random r;
    Thread t2, t3;

    public void run() {
        int num;
        r = new Random();
        try {
            for (int i = 0; i < 4; i++) {
                num = r.nextInt();
                System.out.println("Main Thread and Generated Number is" + num);
                t2 = new Thread(new SquareThread(num));
                t2.start();
                t3 = new Thread(new CubeThread(num));
                t3.start();
                Thread.sleep(1000);
                System.out.println("   ");
            }
        } catch (Exception e) {
            System.out.println("Interrupted Exception!!");
        }
    }
}


// End of the program No.3 b(Multi Threading)

// Start of Merge Sort Algorithm (Program No.4) Program
class mergeSort {
    int max = 10000;

    void merge(int[] array, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = low;
        int[] resarray;
        resarray = new int[max];
        while (i <= mid && j <= high) {
            if (array[i] < array[j]) {
                resarray[k] = array[i];
                i++;
                k++;

            } else {
                resarray[k] = array[j];
                j++;
                k++;
            }
        }
        while (i <= mid)
            resarray[k++] = array[i++];
        while (i <= high)
            resarray[k++] = array[j++];
        for (int m = low; m <= high; m++)
            array[m] = resarray[m];

    }

    void sort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            sort(array, low, mid);
            sort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    // public static void mian(String[] args) {
    // int[] array;
    // int i;
    // System.out.println("enter the array size");
    // Scanner sc = new Scanner(System.in);
    // int n = sc.nextInt();
    // array = new int[max];
    // Random generator = new Random();
    // for (i = 0; i < n; i++)
    // array[i] = generator.nextInt(20);
    // System.out.println(array[i] + "");
    // long startTime = System.nanoTime();
    // mergesort m = new mergesort();
    // m.sort(array, 0, n - 1);
    // long stopTime = System.nanoTime();
    // long elapseTime = (stopTime - startTime);
    // System.out.println("sorted array is");
    // for (i = 0; i < n; i++)
    // System.out.println(array[i]);
    // System.out.println("time taken to sort array is:" + elapseTime +
    // "nanoseconds");

    // }
}

// End of Merge Sort Algorithm (Program No.4) Program

// Start of Quick Sort(Program No.5) Program

class quickSort {
    static int max = 10000;

    int partition(int[] a, int low, int high) {
        int p, i, j, temp;
        p = a[low];
        i = low + 1;
        j = high;
        while (low < high) {
            while (a[i] <= p && i < j)
                i++;
            while (a[j] > p)
                j--;
            if (i < j) {
                temp = a[j];
                a[i] = a[j];
                a[j] = temp;
            } else {
                temp = a[low];
                a[low] = a[j];
                a[j] = temp;
                return j;
            }

        }
        return j;
    }

    void sort(int[] a, int low, int high) {
        if (low < high) {
            int s = partition(a, low, high);
            sort(a, low, s - 1);
            sort(a, s + 1, high);
        }
    }

}

// End of Quick Sort(Program No.5) Program

// Start of the knapsackAlgorithm (Program no. 6)
class KObjectAlgo {

    float w;
    float p;
    float r;
}

class knapSackAlgo {

    static final int max = 20;
    int n;
    static float m;

    void readObjects(KObjectAlgo obj[]) {
        KObjectAlgo temp = new KObjectAlgo();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the max capacity of Knap Sack : ");
        m = sc.nextFloat();
        System.out.println("Enter weight : ");
        for (int i = 0; i < n; i++) {
            obj[i].w = sc.nextFloat();
        }
        System.out.println("Enter the Profit : ");
        for (int i = 0; i < n; i++) {
            obj[i].p = sc.nextFloat();
        }
        for (int i = 0; i < n; i++) {
            obj[i].r = obj[i].p / obj[i].w;
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (obj[j].r < obj[j++].r) {
                    temp = obj[i];
                    obj[j] = obj[j + 1];
                    obj[j + 1] = temp;
                }
            }
        }
        // sc.close();
    }

    void knapSack(KObjectAlgo kobj[]) {
        float x[] = new float[max];
        float totalProfit;
        int i;
        float u = m;
        totalProfit = 0;
        for (i = 0; i < n; i++) {
            x[i] = 0;
        }
        for (i = 0; i < n; i++) {
            if (kobj[i].w > u) {
                break;
            } else {
                x[i] = 1;
                totalProfit = totalProfit + kobj[i].p;
                u = u - kobj[i].w;
            }
        }
        System.out.println("i = " + i);
        if (i < n) {
            x[i] = u / kobj[i].w;
        }
        totalProfit = totalProfit + (x[i] * kobj[i].p);
        System.out.println("The Solution vector , x[] : ");
        for (i = 0; i < n; i++) {
            System.out.println(x[i] + " ");
        }
        System.out.println("Total Profit = " + totalProfit);
    }

}

// End of the knapsackAlgorithm(Program no. 6)

// Start of Prims Algorithm(Program No.7) Program

class primsclass {
    final static int max = 20;
    static int n;
    static int cost[][];
    static Scanner scan = new Scanner(System.in);

    // public static void main(String[]args){
    // readmatrix();
    // prims();
    // }
    void readmatrix() {
        int i, j;
        cost = new int[max][max];
        System.out.println("Enter the number of nodes");
        n = scan.nextInt();
        System.out.println("Enter the adjacency matrix:");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                cost[i][j] = scan.nextInt();
                if (cost[i][j] == 0)
                    cost[i][j] = 999;
            }
        }

    }

    void prims() {
        int visited[] = new int[10];
        int ne = 1, i, j, min, a = 0, b = 0, u = 0, v = 0;
        int minCost = 0;
        visited[1] = 1;
        while (ne < n) {
            for (i = 1, min = 999; i <= n; i++) {
                for (j = 1; j <= n; j++) {
                    if (cost[i][j] < min) {
                        if (visited[i] != 0) {
                            min = cost[i][j];
                            a = u = i;
                            b = v = j;

                        }
                    }
                    if (visited[u] == 0 || visited[v] == 0) {
                        System.out.println("Edge  " + ne++ + ": ( " + a + "," + b + ")" + " cost : " + min);
                        minCost += min;
                        visited[b] = 1;
                    }
                    cost[a][b] = cost[b][a] = 999;
                }

            }
            System.out.println("\n Minimum Cost : " + minCost);
        }

    }
}

// End of Prims Algorithm(Program No.7) Program

// Start of the Kruskal Algorithm(Program no. 8) Program

class kruskalAlgo {

    final static int max = 20;
    static int n;
    static int cost[][];
    static Scanner sc = new Scanner(System.in);

    void readMatrix() {
        int i, j;
        cost = new int[max][max];
        System.out.println("Enter the no. of vertices : ");
        n = sc.nextInt();
        System.out.println("Enter the cost adjacent Matrix : ");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                cost[i][j] = sc.nextInt();
                if (cost[i][j] == 0) {
                    cost[i][j] = 999;

                }

            }

        }
    }

    // Calling this method from the main method with the object name pg8
    void kruskals() {
        int a = 0, b = 0, u = 0, v = 0, i, j, ne = 1, min, minCost = 0;
        System.out.println("The Edges of Minimum Spanning trees ");
        while (ne < n) {
            for (i = 1, min = 999; i <= n; i++) {
                for (j = 1; j <= n; j++) {
                    if (cost[i][j] < min) {
                        min = cost[i][j];
                        a = u = i;
                        b = v = j;

                    }
                }
            }
            u = find(u);
            v = find(v);
            if (u != v) {
                uni(u, v);
                System.out.println(ne++ + " Edge (" + a + "," + b + ")=" + min);
                minCost += min;
            }
            cost[a][b] = cost[b][a] = 999;
        }
        System.out.println("Minimum cost : " + minCost);
    }

    static int find(int i) {
        int parent[] = new int[9];
        while (parent[i] == 1) {
            i = parent[i];
        }
        return i;
    }

    static void uni(int i, int j) {
        int parent[] = new int[9];
        parent[j] = i;
    }
}

// End of the Kruskal Algorithm(Program No.8) Program

// Start of the Dijikstra's Algorithm(Program No.9) Program

class DijikstrasClass {

    final static int MAX = 20;
    final static int infinity = 99;
    static int n;
    static int a[][];
    static Scanner sc = new Scanner(System.in);

    // public static void main(String[] args) {
    // ReadMatrix();
    // int s;
    // System.out.println("Enter the Starting Matrix : ");
    // s = sc.nextInt();
    // dijikstra(s);
    // }

    void ReadMatrix() {
        a = new int[MAX][MAX];
        System.out.println("Enter the no. of Vertices : ");
        n = sc.nextInt();
        System.out.println("Enter the cost adjacency Matrix : ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
    }

    void dijikstra(int s) {
        int S[] = new int[MAX];
        int d[] = new int[MAX];
        int u, v;
        int i;
        for (i = 1; i <= n; i++) {
            S[i] = 0;
            d[i] = a[s][i];
        }
        S[s] = 1;
        d[s] = 1;
        i = 2;
        while (i <= n) {
            u = ExtractMin(S, d);
            S[u] = 1;
            i++;
            for (v = 1; v <= n; v++) {
                if (((d[u] + a[u][v]) < d[v]) && (S[v] == 0)) {
                    d[v] = d[u] + a[u][v];

                }
            }
        }
        for (i = 1; i <= n; i++) {
            if (i != s)
                System.out.println(i + " : " + d[i]);
        }
    }

    static int ExtractMin(int[] S, int[] d) {
        int i, j = 1, min;
        min = infinity;
        for (i = 1; i <= n; i++) {
            if ((d[i] < min) && (S[i] == 0)) {
                min = d[i];
                j = 1;
            }
        }
        return (j);

    }

}

// End of the Dijikstra's Algorithm(Program No.9) Program

// Start of the Floyd's Algorithm(Program No.10) Program
class floydsClass {

    final int max = 10;
    int a[][];
    static int n;

    // public static void main(String[] args) {
    // a = new int[max][max];
    // readMatrix();
    // floyds();
    // printMatrix();
    // }

    void readMatrix() {
        System.out.println("Enter the number of vertices : ");
        Scanner scF = new Scanner(System.in);
        n = scF.nextInt();
        System.out.println("Enter cost matrix \n (999 for infinity) ");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++)
                a[i][j] = scF.nextInt();
        }
        // scF.close();

    }

    void floyds() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if ((a[i][k] + a[k][j]) < (a[i][j]))
                        a[i][j] = a[i][k] + a[k][j];
                }
            }

        }
    }

    void printMatrix() {
        System.out.println("The All pair shortest pair matrix is : \n");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.println(a[i][j] + " ");
            }
            System.out.println();

        }

    }

}

// End of the Floyd's Algorithm(Program No.10) Program

/**
 * ********************************************* Start of the Main Class***
 *************************************************************************************
 */
public class mainClass {

    static Scanner sc = new Scanner(System.in);

    /**
     * @param args
     */
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n----------MENU----------\n");
            System.out.println("\nEnter the program No. : ");
            System.out.println(
                    " 1. a : Student Details \n    b : Stack Operations \n 2. a: Staff Details \n    b: To Store the Customer Name and D.O.B \n 3. a: Read ,Compute and Print two Integers \n    b: Multi-Thread Applications \n 4.Merge Sort Algorithm \n 5.Quick Sort Algorithm \n 6.KnapSack Algorithm \n 7.Prims Algorithm \n 8.Kruskal's Algorithm \n 9.Dijikstra's Algorithm \n 10.Floyd's Algorithm \n 11.EXIT \n\n");
            int choice = sc.nextInt();
            char ch2;
            switch (choice) {
                case 1:
                    System.out.println("Program No.1 :\na : Student Details \nb : Stack Operations \n \n");
                    // System.out.println("Choose 1 for program a or 2 for program b  \n ");
                    ch2 = sc.next().charAt(0);
                    if (ch2 == 'a') {
                        System.out.println("\n1.a : Student Details Program \n");
                        studentDetails s[] = new studentDetails[10];
                        Scanner sc = new Scanner(System.in);
                        System.out.println("\nEnter the number of Students : ");
                        int n = sc.nextInt();
                        for(int i=0;i<n;i++){
                            s[i] = new studentDetails();
                        }
                        for(int i=0;i<n;i++){
                            System.out.println("\nEnter the NAME,USN,BRANCH,PHONE of Student "+(i+1)+" : ");
                
                            System.out.println("\nEnter the NAME of Student "+(i+1)+" : ");
                            String name = sc.next();
                            System.out.println("\nEnter the USN of Student "+(i+1)+" : ");
                            String usn = sc.next();
                            System.out.println("\nEnter the BRANCH of Student "+(i+1)+" : ");
                            String br = sc.next();
                            System.out.println("\nEnter the Phone No. of Student "+(i+1)+" : ");
                            String ph = sc.next();
                            s[i].insertRecord(name, usn, br, ph);
                        }
                
                        for(int i=0;i<n;i++){
                            System.out.println("\nStudent Details are :");
                            s[i].displayRecord();
                        }

                    } else if (ch2 == 'b') {
                        System.out.println("\n1.b : Stack Operations Program \n");
                        stack st = new stack();
                        endPrgm:
                        while (true) {

                            System.out.println("------Stack Operations-----");
                            System.out.println("1.Push");
                            System.out.println("2.Pop");
                            System.out.println("3.Display");
                            System.out.println("4.Exit");

                            System.out.println("Enter your Choice : ");
                            int ch = sc.nextInt();

                            switch (ch) {
                                case 1:
                                    st.Push();
                                    break;

                                case 2:
                                    st.Pop();
                                    break;

                                case 3:
                                    st.Display();
                                    break;

                                case 4:
                                    // System.exit(0);
                                    // continue;
                                    // break;
                                    break endPrgm;
                                default:
                                    System.out.println("Invalid Operation");
                                    break;
                            }

                        }

                    } else {
                        System.out.println("Choose Either a or b!!");
                    }
                    break;
                case 2:
                    System.out.println(
                            "Program No.2 :\n a :  Staff Details Program\n b : To Store the Customer Name and D.O.B \n \n");
                    // System.out.println("Choose 1 for program a or 2 for program b\n ");
                    ch2 = sc.next().charAt(0);
                    if (ch2 == 'a') {
                        System.out.println("2.a :  Staff Details Program \n");
                        System.out.println("Enter the  Number of Staff :");
                        int n = sc.nextInt();

                        //Details of the teaching staff

                        ATeaching ob[]=new ATeaching[10];
                        System.out.println("\nEnter the Teaching Staff Details :");
                        for(int i=0;i<n;i++){
                        ob[i]=new ATeaching();
                        }
                        for(int i=0;i<n;i++){
                        ob[i].read();
                        ob[i].read1();
                        System.out.println("\nTeaching Staff Details :");
                        ob[i].disp();
                        ob[i].disp1();
                        }

                        //Details of the Technical staff
                        ATechnical ob1[]=new ATechnical[10];
                        System.out.println("\n\nEnter the Technical Staff Details :");
                        for(int i=0;i<n;i++){
                        ob1[i]=new ATechnical();
                        }
                        for(int i=0;i<n;i++){
                        ob1[i].read();
                        ob1[i].read2();
                        System.out.println("\nTechnical Staff Details :");
                        ob1[i].disp();
                        ob1[i].disp2();
                        }

                        //Details of the Contract Staff
                        AContract ob2[]=new AContract[10];
                        System.out.println("\n\nEnter the Contract Staff Details :");
                        for(int i=0;i<n;i++){
                        ob2[i]=new AContract();
                        }
                        for(int i=0;i<n;i++){
                        ob2[i].read();
                        ob2[i].read3();
                        System.out.println("\nContract Staff Details :");
                        ob2[i].disp();
                        ob2[i].disp3();
                        }

                    } else if (ch2 == 'b') {
                        System.out.println("2.b : To Store the Customer Name and D.O.B Program \n");
                        customer pg2a = new customer();
                        pg2a.pg2_b();

                    } else {
                        System.out.println("Choose Either a or b!!");
                    }

                    break;

                case 3:
                    System.out.println(
                            "Program No.3 :\n a : Read ,Compute and Print two Integers \n b : Multi-Thread Applications \n \n");
                    // System.out.println("Choose 1 for program a or 2 for program b \n ");
                    ch2 = sc.next().charAt(0);
                    if (ch2 == 'a') {
                        System.out.println("3.a : Read ,Compute and Print two Integers Program \n");
                        divison pg3a = new divison();
                        pg3a.pg3_a();
                    } else if (ch2 == 'b') {
                        System.out.println("3.b : Multi-Thread Applications Program \n");
                        RandomThread thread_obj = new RandomThread();
                        Thread t1 = new Thread(thread_obj);
                        t1.start();
                        break;
                    } else {
                        System.out.println("Choose Either a or b!!");
                    }
                    break;
                case 4: {
                    System.out.println("Program No.4 : Merge Sort Algorithm \n");
                    mergeSort pg4 = new mergeSort();
                    int[] array;
                    int i;
                    int maxValue = pg4.max;
                    System.out.println("enter the array size");
                    Scanner sc = new Scanner(System.in);
                    int n = sc.nextInt();
                    array = new int[maxValue];
                    Random generator = new Random();
                    for (i = 0; i < n; i++)
                        array[i] = generator.nextInt(20);
                    System.out.println(array[i] + "");
                    long startTime = System.nanoTime();
                    mergeSort m = new mergeSort();
                    m.sort(array, 0, n - 1);
                    final long stopTime = System.nanoTime();
                    long elapseTime = (stopTime - startTime);
                    System.out.println("sorted array is");
                    for (i = 0; i < n; i++)
                        System.out.println(array[i]);
                    System.out.println("time taken to sort array is:" + elapseTime + "nanoseconds");
                }
                    break;
                case 5:
                    quickSort pg5 = new quickSort();
                    System.out.println("Program No.5 : Quick Sort Algorithm \n");
                    int[] a;
                    int i;
                    System.out.println("Enter the array size :");
                    // Scanner sc = new Scanner(System.in);
                    int n = sc.nextInt();
                    a = new int[pg5.max];
                    Random generator = new Random();
                    for (i = 0; i < n; i++)
                        a[i] = generator.nextInt(1000);
                    System.out.println("Array Before Sorting : ");
                    for (i = 0; i < n; i++) {
                        System.out.println(a[i] + " ");
                    }
                    long startTime = System.nanoTime();
                    quickSort m = new quickSort();
                    m.sort(a, 0, n - 1);
                    long stopTime = System.nanoTime();
                    long elapseTime = (stopTime - startTime);
                    System.out.println("Sorted Array is : ");
                    for (i = 0; i < n; i++)
                        System.out.println(a[i]);
                    System.out.println("Time Taken To Sort the array is " + elapseTime + " nanoseconds");
                    break;
                case 6:
                    knapSackAlgo pg6 = new knapSackAlgo();
                    // knapSack pg6 = new knapSack();
                    System.out.println("Program No.6 : KnapSack Algorithm \n");
                    // Scanner scanner = new Scanner(System.in);
                    System.out.println("Enter the no. of objects : ");
                    pg6.n = sc.nextInt();
                    KObjectAlgo[] obj = new KObjectAlgo[pg6.n];
                    for (int q = 0; q < pg6.n; q++) {
                        obj[q] = new KObjectAlgo();
                    }
                    pg6.readObjects(obj);
                    pg6.knapSack(obj);
                    // sc.close();
                    break;
                case 7:
                    System.out.println("Program No.7 : Prims Algorithm \n");
                    primsclass pg7 = new primsclass();
                    pg7.readmatrix();
                    pg7.prims();
                    break;
                case 8:
                    System.out.println("Program No.8 : Kruskal Algorithm \n");
                    kruskalAlgo pg8 = new kruskalAlgo();
                    pg8.readMatrix();
                    pg8.kruskals();
                    break;

                case 9:
                    System.out.println("Program No.9 : Dijikstra's Algorithm \n");
                    DijikstrasClass pg9 = new DijikstrasClass();
                    pg9.ReadMatrix();
                    int s;
                    System.out.println("Enter the Starting Matrix : ");
                    s = sc.nextInt();
                    pg9.dijikstra(s);
                    break;
                case 10:
                    System.out.println("Program No.10 : Floyd's Algorithm \n");
                    floydsClass pg10 = new floydsClass();
                    int maxval = pg10.max;
                    pg10.a = new int[maxval][maxval];
                    pg10.readMatrix();
                    pg10.floyds();
                    pg10.printMatrix();
                    break;
                case 11:
                    System.out.println("Exited!!\n");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice");

            }

        }

    }

}
/**
 * ********************************************* End of the Main Class***
 *************************************************************************************
 */
