/*
 * James Hawkins
 * CIT 203
 * Assignment 2
 */
import java.util.*;

public class Frog implements Critter{
    //fields
    private int moves;
    private int movement;
    
    //constructor
    public Frog(){
        this.moves=0;
        this.movement=0;
    }

    //returns char to represent the type of critter
    public char getChar(){
        return 'F';
    }

    //returns int to represent the move of critter
    public int getMove(CritterInfo info){
       moves++;
       if (this.moves>=3)
           this.moves =0;

       Random rand = new Random();
       if (this.moves==0)
       this.movement = rand.nextInt(5);
       if(this.movement==0)
           return NORTH;
       else if(this.movement==1)
           return EAST;
       else if(this.movement==2)
           return SOUTH;
       else if(this.movement==3)
           return WEST;
       else 
           return CENTER;

    }
}
