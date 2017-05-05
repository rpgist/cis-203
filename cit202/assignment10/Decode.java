/*
 * James Hawkins
 * CIT 203
 * Assignment 11
*/
import java.util.*;
import java.io.*;

public class Decode{
    //PostCOndition: everything in the coded.txt is decoded and
    //               output to decoded.txt
     public static void Decode() throws FileNotFoundException{
        //makes a scanner on ohe file
        Scanner sc = new Scanner(new File("coded.txt"));
        File file = new File("decoded.txt");
        //opens a PrintStream
        PrintStream ps = new PrintStream(file);
        //puts each word in the array
        String line = sc.nextLine();
        while(sc.hasNextLine()){
            //opens scanner on the line
            Scanner lineSc = new Scanner(line);
            //creates an array to put the words in
            ArrayList<String> wordArray= new ArrayList<String>();
            //goes through the individual words
            while(lineSc.hasNext()){
                String word = lineSc.next();
                //makes a string to store the current letter
                String letter = "";
                for(int i = 0; i< word.length();i++){
                    if(word.charAt(i)=='.' || word.charAt(i)=='-'){
                        letter += word.charAt(i);
                    }else if (word.charAt(i)=='|'){
                        wordArray.add(letter);
                        letter="";
                    }else{
                        letter+= word.charAt(i);
                    }
                }
                wordArray.add(letter);
                letter ="";
                //adds a space after the word
                if(lineSc.hasNext()){
                    wordArray.add(" ");
                }else{
		            break;
                }
            }
            //calls wordProcessor to decode and print chars
            wordProcessor(wordArray, ps);
            //ends the line in the output.txt
            ps.println();
            line= sc.nextLine();
        }
        
   }
    
    //Parameters:is passes the wordArray containing each letter
   //            as well as the PrintStream
   //PostCondition: the char is added to the decoded.txt
    private static void wordProcessor(ArrayList<String> word, PrintStream ps){
        for(int i=0;i < word.size(); i++){
	        //testing purposes
            //System.out.println(word.get(i));
            //outputs the decoded char to output.txt
	        ps.print(MorseCode.getLetter(word.get(i)));
	  }
   }
   //PostCondition: the coded.txt is decoded and output to decoded.txt
   public static void main(String [] args)throws FileNotFoundException{
   Decode();
   } 
}
