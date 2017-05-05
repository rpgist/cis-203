/*
 * James Hawkins
 * CIT 203
 * Assignment 11
*/
import java.util.*;
import java.io.*;
public class MorseCode {

    private static TreeNode<Character> codeTree = MorseCode.buildTree();

    // write and comment getLetter() here
    // Parameter: takes a string to convert to a char
    // Returns: a character decoded
    public static Character getLetter(String code){
        TreeNode<Character> current = codeTree;
        System.out.println(code);
        if(code.charAt(0) != '.' && code.charAt(0) != '-')
	    return code.charAt(0);
        for(int i = 0; i<code.length(); i++){
            if(code.charAt(i)=='.'){
                current = current.left;
            }
            if(code.charAt(i)=='-') {
                current = current.right;
            }            
        }
        return current.data;
    }

    // Returns: a binary tree that represents the Morse code for the Roman
    //          alphabet
    private static TreeNode<Character> buildTree () {
        // build left half
	TreeNode<Character> s =  new TreeNode<Character>('S', 
                                       new TreeNode<Character>('H'),
					       new TreeNode<Character>('V'));

	TreeNode<Character> u =  new TreeNode<Character>('U', 
                                       new TreeNode<Character>('F'),
						     null);
	TreeNode<Character> i =  new TreeNode<Character>('I', s, u);


	TreeNode<Character> r =  new TreeNode<Character>('R', 
                                        new TreeNode<Character>('L'), 
                                                      null);

	TreeNode<Character> w =  new TreeNode<Character>('W', 
                                       new TreeNode<Character>('P'),
					       new TreeNode<Character>('J'));

	TreeNode<Character> a =  new TreeNode<Character>('A', r, w);


	TreeNode<Character> e =  new TreeNode<Character>('E', i, a);

        // build right half

	TreeNode<Character> d =  new TreeNode<Character>('D', 
                                       new TreeNode<Character>('B'),
					       new TreeNode<Character>('X'));

	TreeNode<Character> k =  new TreeNode<Character>('K', 
                                       new TreeNode<Character>('C'),
					       new TreeNode<Character>('Y'));

	TreeNode<Character> n =  new TreeNode<Character>('N', d, k);


	TreeNode<Character> g =  new TreeNode<Character>('G', 
                                       new TreeNode<Character>('Z'),
					       new TreeNode<Character>('Q'));

	TreeNode<Character> o =  new TreeNode<Character>('O');

	TreeNode<Character> m =  new TreeNode<Character>('M', g, o);

	TreeNode<Character> t =  new TreeNode<Character>('T', n, m);

        // build the root

	TreeNode<Character> root =  new TreeNode<Character>(null, e, t);

	return root;
    }
}
