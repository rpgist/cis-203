/*
 * James Hawkins
 * CIT 203
 * Assignment 5 part 1
 */
import java.util.*;
import java.io.*;
public class EditDistance_1{
    public static void main(String[] args)throws FileNotFoundException{
        giveIntro();
        File file = getFile();
        Scanner dictionaryScanner = new Scanner(file);
        Map<String, List<String>> neighbors = buildMap(dictionaryScanner);
        doMatches(neighbors);
    }

    //give intro tells users how to use program
    public static void giveIntro(){
        System.out.println("This program uses a dictionary to compute the");
        System.out.println("edit distances between pairs of words");
    }

    //prompts user for file to be used as dictionary
    public static File getFile(){
        Scanner sc = new Scanner(System.in);
        System.out.print("What is the dictionary file? ");
        File f = new File(sc.next());
        System.out.println();
        while(!f.exists()){
            System.out.println("File not found. What is the dictionary file? ");
            f= new File(sc.next());
        }
        return f;
    }

    //stub to represent buildmap
    public static Map<String, List<String>> buildMap(Scanner sc){
        while(sc.hasNext()){
            System.out.print(sc.next()+" ");
        }
        System.out.println();
        return null;
    }

    //stub to represent doMatches
    public static void doMatches(Map<String, List<String>> map){
        //is a stub
    }

}
