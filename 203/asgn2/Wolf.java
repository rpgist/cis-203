/*
 * James Hawkins
 * CIT 203
 * Assignment 2
 */
import java.util.*;
public class Wolf implements Critter{
    //returns char representing the type of critter
    public char getChar(){
        return 'W';
    }

    //returns the direction the wolf is movig in
    //trys to avoid other critters
    public int getMove(CritterInfo info){
        int movement=0;
        //selects a random direction till its finds an empty path
        Random rand = new Random();
        //gives the wolf 4 chances to find a safe direction
        for(int i = 0; i<=3; i++){
            //selects a random number to represent direction
            movement= rand.nextInt(4);
            //checks if the direction is clear
            if(movement==0 && info.getNeighbor(NORTH)==('.'))
                return NORTH;
            else if(movement==1 && info.getNeighbor(EAST)==('.'))
                return EAST;
            else if(movement==2 && info.getNeighbor(SOUTH)==('.'))
                return SOUTH;
            else if(movement==3 && info.getNeighbor(WEST)==('.'))
                return WEST;
       }
       //the wolf is surrounded 
       return CENTER;
    }
}
