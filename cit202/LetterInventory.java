/*
James Hawkins
CIS 203
Section 1
Assignment 3
*/
import java.util.*;
public class LetterInventory{
    
    //fields
    private ArrayList<Integer> list = new ArrayList<Integer>();
    private int size; 
    
    public static boolean anagrams(String s1, String s2){
	LetterInventory l1 = new LetterInventory(s1);
	LetterInventory l2 = new LetterInventory(s2);
	return l1.equals(l2);
    }

    //constructors
    public LetterInventory(String word){
	for(int i = 0; i < 26; i++){
	    list.add(0);
	}
	String lower = lowerCase(word);
	for (int i;i < word.length(); i++){
	    int w = word.charAt(i) - 'a';
	    
	}
    }

    //methods
    
    public int size(){
	return list.size();
    }
    
    public boolean equals (Object obj){
	if (!(obj instanceof LetterInventory ));
	    return false;
	LetterInventory test = (LetterInventory) obj;
	for (int i = 0; i < list.size(); i++){
	    if (list.get(i) != test.get((char)(i+ 'a')))
		return false;
	}
	return true;
    }
	 
    public boolean isEmpty(){
	if (list.size() == 0)
	    return true;
	else
	    return false;
    }
    
    public int get(char letter){
	int count = 0;
	for (int i = 0; i<list.size(); i++){
	    if (list.contains(letter))
		count++;
	}	
	return count;
    }
    
    public void set(char letter, int value){
	int location = letter - 'a';
	if (location<0)
	    throw new IllegalArgumentException("Value too low. Cannot pass negative numbers");
	else{
	    list.set(location,value);
	    size-=list.get(letter);
	    size+= value;
	}
    }
    
    public LetterInventory add(LetterInventory other){
	LetterInventory result = new LetterInventory("");
	for(int i = 0; i < 26; i++){
	    result.set((char)(other.get(i) + 'a'), 1);
	    result.set(list.get(((char)i) + 'a'), 1);
	}
    }
    
    public LetterInventory subtract(LetterInventory other){
	LetterInventory result = new LetterInventory("");
	for (int i = 0; i < 26; i++){
	    result.set(other.charAt(i), -1);
	    result.set(list.charAt(i), -1);
	    if(result.charAt(i) <0){
		return null;
	    }
	}
    }

    //Parameter: is passed the string of random letters
    //Returns: the string in all lowercase
    private String lowerCase(String s){
	String result= "";
	for(int i = 0; i < s.length(); i ++){
	    char aChar = s.charAt(i);
	    if ('A' <= aChar && aChar <= 'Z')
		aChar = (char)(aChar + 'a');
	    result += aChar;
	}
	return result;
    }
    
    public String toString(){
	String Product = "[ ";
	String Inventory="";
	for (int i = 0; i<list.size(); i++){
	    Inventory+= list.get(i);
	}
	Inventory = lowerCase(Inventory);
	for (int i = 0; i < Inventory.length(); i++){
	    Product += Inventory.indexOf(i);
	}
    }
}