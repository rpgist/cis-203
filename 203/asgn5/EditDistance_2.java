/*
 * James Hawkins
 * CIT 203
 * Assignment 5 part 2
 */
import java.util.*;
import java.io.*;
public class EditDistance_2{
    public static void main(String[] args)throws FileNotFoundException{
        giveIntro();
        File file = getFile();
        Scanner dictionaryScanner = new Scanner(file);
        Map<String, List<String>> neighbors = buildMap(dictionaryScanner);
        System.out.println(neighbors);
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

    public static Map<String, List<String>> buildMap(Scanner sc){
        Map<String, List<String>> map = new TreeMap<String, List<String>>();
        List<String> list1 = new ArrayList<String>();
        while(sc.hasNext()){
            list1.add(sc.next());
        }
        for(String var1 : list1){
            List<String>list2=new ArrayList<String>();
            for(String var2:list1){
                if(isNeighbor(var1,var2)){
                    list2.add(var2);
                }
            }
            map.put(var1,list2);
        }
        return map;
    }

    //stub to represent doMatches
    public static void doMatches(Map<String, List<String>> map){
        //is a stub
    }

    //helper method for buildMap
    public static boolean isNeighbor(String str1, String str2){
        if(str1.length()!= str2.length()){
            return false;
        }
        int dif =0;
        for(int i = 0; i<str1.length();i++){
            if(str1.charAt(i)!=str2.charAt(i)){
                dif++;
            }
        }
        return dif==1;
    }

}
