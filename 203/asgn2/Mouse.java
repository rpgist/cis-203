/*
 * James Hawkins
 * CIT 203
 * Assignment 2
 */
public class Mouse implements Critter{
    //fields
    private int moves; 

    //constructor
    public Mouse(){
        this.moves=0;
    }

    //returns char to represent type of critter
    public char getChar(){
        return 'M';
    }

    //returns int to represent the critters move
    public int getMove(CritterInfo info){
        moves++;
        if(moves>1)
            moves=0;
        if(moves ==0)
            return WEST;
        else
            return NORTH;
    }
}
