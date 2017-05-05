import java.util.*;
public class CombinationLock {
    LinkedList<Character> lock=new LinkedList<>();
    LinkedList<Integer> nums=new LinkedList<>();
    public CombinationLock(){
        buildLock(true);
        displayLock();
    }
    //methods
    private void buildLock(boolean init){
        lock.clear();
        for(int i=0;i<39;i++){
            lock.add('-');
            if(init)
                nums.add(i);
        }
    }
    private void displayLock(){
        int count=0;
            System.out.println("            " + nums.getFirst());
            for(int i=0; i <10 ; i++){
                    for (int j = 12; j>0+i ; j--){
                    System.out.print(" ");
                    }
                    System.out.print(lock.get(count++));
                    if(i == 0)
                    System.out.println();
                    if(i!=0){
                    for(int j= 1; j< 2*i; j++){
                            System.out.print(" ");
                    }
                System.out.println("-");
                    }
            }
           
       
            //Postcondition: prints the middle line
 
            System.out.print(nums.get(count+20)+""+ lock.get(count++));
            for(int i = 0; i<19; i++){
                    System.out.print(" ");
            }
            System.out.println(lock.get(count) +""+ nums.get(count++-1));
           
       
            //Postcondition: prints the bottom of the lock
 
            for(int i=0; i<10; i++){
                    for (int j= i+3; j>0; j--){
                    System.out.print(" ");
                    }
                    if(i!=9)
                    System.out.print(lock.get(count++));
                    for (int j=18-(2*i); j>1;j--){
                    System.out.print(" ");
                    }
                    System.out.println("-");
            }
            System.out.println("            "+nums.get(count-1));
}
 
    public void turn(boolean turn, int amt){
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
    public static void main(String[] args){
        CombinationLock hi=new CombinationLock();
        hi.turn(true, 4);
    }
}
