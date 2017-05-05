/*
 * James Hawkins
 * CIT 203
 * Assignment 2
 */
public class Turtle implements Critter{
    //fields
    private int moves;
    private int movement;

    //constructor
    public Turtle(){
        this.moves =0;
        this.movement=0;
    }

    //returns char representing the type of critter
    public char getChar(){
        return 'T';
    }

    //returns int representing the critters move
    public int getMove(CritterInfo info){
        moves++;
        if(moves>=20)
            moves =0;
        if(moves<5)
            return SOUTH;
        else if(moves>=5 && moves<10)
            return WEST;
        else if(moves>=10 && moves<15)
            return NORTH;
        else 
            return EAST;
    }
}
