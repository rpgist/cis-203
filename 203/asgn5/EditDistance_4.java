/*
 * James Hawkins
 * CIT 203
 * Assignment 5 part 4
 */
import java.util.*;
import java.io.*;
public class EditDistance_4{
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

    public static void doMatches(Map<String, List<String>> map){
        System.out.println("Finding edit distances...");
	//gets words and puts them in a list
	List<String> list = getWords(map);
	String word1=list.get(0);
	String word2=list.get(1);
    System.out.println("word1 is : "+word1);
    System.out.println("word2 is : "+word2);
	//calls editDistance
	int distance = editDistance(word1,word2,map);
	if(distance == -1){
	    System.out.println("No Solution");
	}else{
	    System.out.println("Distance: "+ distance);
	}
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

    //gets two words to calculate distance
    public static List<String> getWords(Map<String, List<String>> map){
	List<String> list = new ArrayList<String>();
	Scanner sc = new Scanner(System.in);
	//gets the first word
	System.out.print("word 1: ");
	String var1 = sc.nextLine();
	if(var1.isEmpty()){
	    return list;
	}
	while(var1.length()>0 && !map.containsKey(var1)){
	    System.out.println(var1 + " is not in the dictionary");
	    System.out.print("word 1: ");
	    var1 = sc.nextLine();
	    if(var1.isEmpty()){
		return list;
	    }
	}
	//gets the second word
	System.out.print("word 2: ");
	String var2 = sc.nextLine();
	if(var2.isEmpty()){
	    return list;
	}
	System.out.println();
	while(var2.length()>0 && !map.containsKey(var2)){
	    System.out.print("word 2: ");
	    var2 = sc.nextLine();
	    if(var2.isEmpty()){
		return list;
	    }
	    if(!map.containsKey(var2)){
		System.out.println(var2 + " is not in the dictionary");
	    }
	}
	list.add(var1);
	list.add(var2);
	return list;
    }
    
    //calls recursive version of editDistance
    public static int editDistance(String word1, String word2,Map<String, List<String>> map){
	List<String> path=new ArrayList<String>();
	path.add(word1);	
	return editDistance(word1,word2,map,path);
    }

    //recursive version of editDistance
    private static int editDistance(String word1, String word2, Map<String, List<String>> map, List<String>path){
        List<String>tried = new ArrayList<String>();
        if(path.isEmpty()){
            return -1;
        }
        if(word1==word2){
            return path.size()-1;
        }else{
            if(getWord(word1,path,map)==null){
                String temp1=path.get(path.size()-1);
                tried.add(word1);
                path.remove(word1);
                return editDistance(temp1,word2,map,path);          
            }
            path.add(word1);
            tried.add(word1);
            word1=getWord(word1,path,map);
            return editDistance(word1,word2,map,path);
        }
    }

    //printList takes the path and prints it
    private static String printList(List<String>list){
	String result = "[";
	for(int i = 0; i<list.size()-2;i++){
	    result+= list.get(i) +", ";
	}
	result+=list.get(list.size()-1)+"]";
	return result;
    }
    //getWord takes a word and returns the next word to add to the list
    //returns null if we have tried the only available option 
    private static String getWord(String word1, List<String> path, Map<String, List<String>>map){
	List<String> currentList = map.get(word1);
	for(String test: currentList){
	    if(!path.contains(test))
		return test;
	}
	return null;	
    }
} 
