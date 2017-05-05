/*
 * James Hawkins
 * CIS 203
 * Assignment 5.5
 */
import java.util.*;

//not sure how you wanted us to implement the args getting the num
//of steps for the program to run hope this is okay
public class WaysToClimb{
    public static void main(String [] args){
        //int n = Integer.parseInt(args[0]);
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of steps: ");
        int n= Integer.parseInt(sc.next());
        if(n==0){
            System.out.println("[]");
        }else{
            while(n<=0){
                System.out.print("Enter a positive integer!: ");
                n=Integer.parseInt(sc.next());
            }
            String result="";
            int i=0;
            wtc(n,i,result);
        }
    }
    
    public static void wtc(int n, int i, String result){
        if(i==n){
            System.out.println(result.substring(0,(result.lastIndexOf(","))));
        }else if(i<=n){
            wtc(n,i+1,result+"1,");
            wtc(n,i+2,result+"2,");
        }
    }
}
