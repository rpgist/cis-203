/*
James Hawkins
Assignment 9
CIT 203
*/
import java.util.*;
public class CombinationLock {
	//feilds
	LinkedList<Character> lock=new LinkedList<>();
	LinkedList<Integer> nums=new LinkedList<>();
	boolean whichway;
	//constructor
	public CombinationLock(){
		buildLock(true);
		displayLock();
	}
	//methods
	//Postcondition: builds the LinkedLists
	private void buildLock(boolean init){
		lock.clear();
		for(int i=0;i<39;i++){
			lock.add('-');
			if(init)
				nums.add(i);
		}
	}
	//Postcondition: prints the lock to the terminal
	private void displayLock(){
		int count=0;
		int count2=nums.size();
		//displays the top of the triangle 
		System.out.println("            " + nums.getFirst());
		for(int i=0; i <10 ; i++){
		    for (int j = 12; j>i ; j--){
			System.out.print(" ");
		    }
		    if(i==0&&!whichway){
			System.out.print(lock.get(++count));
		    }else{
			  System.out.print(lock.get(--count2));
		    }
		    if(i == 0)
			System.out.println();
		    if(i!=0){
			for(int j= 1; j< 2*i; j++){
			    System.out.print(" ");
			}
		    System.out.println(lock.get(++count));
		    	}
		    }
		    // prints the middle line
		    if(whichway)
			System.out.print(nums.get(++count2)+""+ lock.get(--count2));
		    else
			System.out.print(nums.get(count2)+""+ lock.get(--count2));
			for(int i = 0; i<19; i++){
		    		System.out.print(" ");
			}
			if(whichway)
				System.out.println(lock.get(++count) +""+ nums.get(count));
			else
				System.out.println(lock.get(count) +""+ nums.get(count));	    	
	    	// prints the bottom of the lock

			for(int i=0; i<10; i++){
		    		for (int j= i+3; j>0; j--){
					System.out.print(" ");
		    		}
		    		if(i!=9)
					System.out.print(lock.get(--count2));
		    		for (int j=18-(2*i); j>1;j--){
					System.out.print(" ");
		    		}
		    		System.out.println(lock.get(++count));
			}
			System.out.println("            "+nums.get(count));
}
	//Parameters: takes a direction as a boolean and a int for number of turns
	//Postcondition: changes the two linked lists the direction of the turn
	public void turn(boolean turn, int amt){
		whichway=turn;
		buildLock(false);
		if(turn){
			while(nums.getFirst()!=amt){
				nums.addFirst(nums.removeLast());
				lock.removeLast();
				lock.addFirst('+');
			}
		}else{
			while(nums.getFirst()!=amt){
				nums.addLast(nums.removeFirst());
				lock.removeFirst();
				lock.addLast('+');
			}
		}
		displayLock();
	}
}