/*
James Hawkins
CIT 203
Assignment 9
*/
import java.util.*;

public class GrammarSolver {

    // Declare class variable to hold the grammar dictionary
    private SortedMap<String, String> grammarMap = new TreeMap<String, String>();

    // pre: collection of data for the grammar
    //	    throws IllegalArgumentException if the grammar is empty
    //      or if the grammar contains two of the same nonterminals
    // post: creates a map of the collection for the grammar
    public GrammarSolver(List<String> list) {
        for(int i = 0; i<list.size();i++){
            //array to split keys from values
            String[]part = list.get(i).trim().split("[::=]+");
            String nt = part[0].trim().toLowerCase();
            String values =part[1].toLowerCase();
            //checks if the nt is alreay in the map
            if(!grammarContains(nt)){
                grammarMap.put(nt,values);
            }
        }

    }

    // pre: user enters a string of a symbol
    // post:returns true if that symbol is a nonterminal
    public boolean grammarContains(String rule) {
	return grammarMap.containsKey(rule);
    }

    // post:returns a string representation all the symbols in this grammar
    public String getSymbols() {
        // get the keys
	Set<String> nontermSet = grammarMap.keySet();
	// loop through the symbols and adds to a string
	String symbols = "";
	for (String symb : nontermSet){
            symbols += symb + ",";
        }
        return symbols.substring(0, symbols.length()-1);
    }

    // pre: user enters a symbol and the amount of times to generate a random
    //		grammar of that symbol
    //		throws IllegalArgumentException if the amount of times to generate
    //		is less than 0 or if the symbol is not a key for the map
    // post: returns an array of randomly generated grammars
    public String[] generate(String symbol, int times) {
	if (times <0)
            throw new IllegalArgumentException("The number of times to generate must be positive");
	if (grammarMap.get(symbol) == null)
            throw new IllegalArgumentException("Nonterminal must exist");
        
	// The grammar to return
	String[] grammar = new String[times];
	Random randomGen = new Random();
	// Find the value for the symbol
	String[] termRules = grammarMap.get(symbol).split("[|]");
	for (int i=0; i<times; i++) {		
            // Set the current grammar to blank and pull out a random rule, splitting it up
            // to insure that each part of the rule is taken care of
            grammar[i] = "";
            String[] nonTermRules = termRules[randomGen.nextInt(termRules.length)].trim().split("[ \t|]+");
            // Loop through each rule to see if its a terminal or nonterminal
            for (String ntRule : nonTermRules) {
                if (grammarContains(ntRule)) {
                    String[] adds = generate(ntRule,1);
                    grammar[i] += adds[0];
		} else {
                    if (ntRule.trim().equals("newline")){
			grammar[i] += System.getProperty("line.separator");
                    }else{
			grammar[i] += ntRule + " ";
                    }
		}
            }
	}
	return grammar;
    }
} 
