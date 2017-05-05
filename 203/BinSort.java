/*
James Hawkins
CIT 203
Assignment 6
*/
import java.util.*;
import java.io.*;

public class BinSort{ 
    public static void main(String args[]){
	//gets file name from args
	String fileName = args[0];
	File file = new File(fileName);
	try{
	    //makes scanner on the file
	    Scanner sc = new Scanner(file);
	    //goes through and sorts each line in the file using binsort	
	    while(sc.hasNextLine()){
		//gets the array representation of the line
		ArrayList<Integer>line = getLine(sc.nextLine());
		System.out.println("this is what we are reading in"+line);
		//gets the maximum digits in the line 
		int max = getMax(line);
		System.out.println("this is the max number of digits"+max);
		//sorts the line 
		sortBin(line, max);
		System.out.println("this is the result of binsort:" +line);
	    }
	}catch(Exception ex){
            System.out.println(ex);
	}
    }
    
    //getLine takes an string of ints and returns a arraylist
    private static ArrayList<Integer> getLine(String line){
 	//makes arraylist to put values in
	ArrayList<Integer> result = new ArrayList<Integer>();
	//makes a scanner on the line
	Scanner linesc = new Scanner(line);
	//goes through line and adds the ints to the array
	while(linesc.hasNext()){
	    //converts string to int and adds to the array
	    result.add(Integer.parseInt(linesc.next()));
	}
	//returns the array of ints for the line
	return result;
    }
    
    //takes an array and returns the max number of digits
    private static int getMax(ArrayList<Integer>list){
	int max = list.get(0);
	for(int i=1; i<list.size();i++){
	    if(list.get(i)>max)
		max=list.get(i);
	}
	String temp = ""+max;
	return temp.length();
    }

    //takes an array list and a max int of digits and sorts
    private static void sortBin(ArrayList<Integer>list, int max){
	//makes bin of arraylists
	ArrayList<Integer>[] bin=(ArrayList<Integer>[]) new ArrayList[10];
	//initialize bin
	for(int i=0; i<10;i++){
	    bin[i]=new ArrayList<Integer>();
	}
    //goes through each digit
    for(int i=0;i<max;i++){
        //goes through each number and 
        for(int j=0;j<list.size();j++){
            bin[(list.get(j)/((int)Math.pow(10,i)))%10].add(new Integer(list.get(j)));
        }
        int var = 0;
        for(int j=0;j<list.size();j++){
            if(bin[var].isEmpty()){
                var++; 
                j--;
                continue;
            }
            list.add(j,((Integer)bin[var].remove(0)).intValue());
        }
    }
    
    
    
    
    
    
    
    
    
    
    /*
	boolean last =false;
	int start = 1;
	int temp = -1;
	while(!last){
	    last=true;
	    //split between the arrays
	    for(Integer i:list){
		    temp =i/start;
		    bin[temp%10].add(i);
		    if(last&&temp>0){
		        last =false;
		    }
	    }
	    //put the bin into the arry
	    int var = 0;
	    for(int i = 0; i<10;i++){
		for(Integer j: bin[i]){
		    list.add(var++,j);
		}
		bin[i].clear();
	    }
	    //move to the next digit to sort
	    start*=10;
	}*/
    }
}
