/*
 * James Hawkins
 * CIT 203
 * Assignment 3
 */
import java.util.*;
import java.io.*;
public class Reverser{
    //fields
    private ArrayList<String> list;
    private Scanner sc;
    private File base;
    //constructor
    public Reverser(File input){
        try{
        this.base = input;
        this.sc = new Scanner(base);
        this.list = new ArrayList<String>();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void reverseLines(File output){
        try{
        //make an array list containing the lines
        while (sc.hasNextLine()){
            list.add(sc.nextLine());
        }
        //makes an printstream to output file
        PrintWriter ps = new PrintWriter(output);
        //adds the array backwords
        for(int i=list.size()-1; i>=0; i--){
            ps.println(list.get(i));
        }
        ps.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void reverseEachLine(File output){
       try{
        //make an array list containing the lines
        while (sc.hasNextLine()){
            list.add(sc.nextLine());
        }
        //makes an printstream to output file
        PrintWriter ps = new PrintWriter(output);
        //adds the array backwords
        ArrayList<String> list2 = new ArrayList<String>();
        for(int i=0; i<list.size(); i++){
	        String temp = list.get(i);
	        Scanner lineSc = new Scanner(temp);
	        while(lineSc.hasNext()){
		        list2.add(lineSc.next());
	        }
	        for(int j=list2.size()-1; j>=0; j--){
		        ps.print(list2.get(j)+" " );
	        }
            ps.println();
            list2.clear();
        }
        ps.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void completeReverse(File output){
        try{
        File obj1 = new File("obj1.txt");
        reverseEachLine(obj1);
        Reverser k = new Reverser(obj1);
        k.reverseLines(output);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
