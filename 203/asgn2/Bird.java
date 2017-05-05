/*
 * James Hawkins
 * CIT 203
 * Assignment 2
 */
import java.util.*;
public class Bird implements Critter{
    
    //returns char to identify the type of critter
    public char getChar(){
        return 'B';
    }

    public int getMove(CritterInfo info){
        Random rand = new Random();
        int result;
        result=rand.nextInt(5);
        if(result == 0)
            return NORTH;
        if(result == 1)
            return SOUTH;
        if(result == 2)
            return EAST;
        if(result == 3)
            return WEST;
        else
            return CENTER;
    }

}
