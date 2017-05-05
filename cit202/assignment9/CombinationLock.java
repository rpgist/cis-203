/*
James Hawkins
Assignment 9
CIT 203
*/
public class CombinationLock {
    //feilds 
    private int rotate = 0;
    private LinkedList<Character> lock = new LinkedList<>();
    private LinkedList<Integer> nums= new LinkedList<>();

    //constructor
    public CombinationLock(){
	buildLock(true);
	display();
    }
    
    //methods
    private void buildLock(boolean init){
	lock.clear();
	for(int i=0;i<40;i++){
	    lock.add('-');
	    if(init)
		nums.add(i);
	}
    }
    
    public void turn(boolean direction, int num){
	if(direction){
	    while(nums.getFirst() != num){
		nums.addFirst(nums.removeLast());
		lock.removeLast();
		lock.addFirst('+');
	    }
	    
	}else{
	    while(nums.getFirst() != num){
		nums.addLast(nums.removeFirst());
		lock.removeFirst();
		lock.addLast('+');
	    }
	display();
	buildLock(false);
	}
    }
    //Postcondition: prints the combination lock
    public void display(){
	top();
	middle();
	bottom();
    }
    
    //Postcondition: Prints the top half of the combination lock
    public static void top(){
	System.out.println("             " + nums.getFirst());
	for(int i=0; i <10 ; i++){
	    for (int j = 12; j>0+i ; j--){
		System.out.print(" ");
	    }
	    System.out.print("-");
	    if(i == 0)
		 System.out.println();
	    if(i!=0){
		for(int j= 1; j< 2*i; j++){
		    System.out.print(" ");
		}
		System.out.println("-");
	    }
	}
    }
    
    //Postcondition: prints the middle line
    public static void middle(){
	System.out.print(nums.get(29)+"-");
	for(int i = 0; i<19; i++){
	    System.out.print(" ");
	}
	System.out.println("-" + (nums.get(9)));
    }
    
    //Postcondition: prints the bottom of the lock
    public static void bottom(){
	for(int i=0; i<10; i++){
	    for (int j= i+3; j>0; j--){
		System.out.print(" ");
	    }
	    if(i!=9)
		System.out.print("-");
	    for (int j=18-(2*i); j>1;j--){
		System.out.print(" ");
	    }
	    System.out.println("-");
	}
	System.out.println("            "+(nums.get(19)));
    }



}