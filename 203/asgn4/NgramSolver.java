/*
 * James Hawkins
 * CIT 203
 * Assignment 4
 */
import java.util.*;

public class NgramSolver{
    //fields
    private int gram;
    private Map<String, String> map1;
    private ArrayList<String> start;

    //constructor
    public NgramSolver(int n, String text){
        this.start = new ArrayList<String>();
        this.gram=n;
        this.map1= new TreeMap<String,String>();
        int var=0;
        //makes ngram till the end of the text
        while(var+n<text.length()){
            //makes the ngram
            String ngram="";
            //if its a level 0 ngram
            if(n==0){
                Random rand = new Random();
                for(int i =0;i<text.length()-1;i++){
                    int randomInt= rand.nextInt(text.length()-1);
                    String var1=""+text.charAt(randomInt);
                    map1.put(var1,""+text.charAt(randomInt+1));
                    var+=text.length();
                }
            }else{
                for(int i = var; i<var+n;i++){
                    ngram += text.charAt(i);
                }
                //if its a start it adds it to start list
                if(var==0){
                    start.add(ngram);
                }else{
                    char test= text.charAt(var-1);           
                    if(test=='?' || test =='!' || test =='.'){
                        start.add(ngram);
                    }
                }
                //constructs the map of ngrams 
                if(map1.containsKey(ngram)){
                    String value =""+ text.charAt(var+n);
                    value+=map1.get(ngram);
                    map1.remove(ngram);
                    map1.put(ngram,value);
                    var++;
                }else{
                    if(text.length()>=var+1){
                        String value =""+ text.charAt(var+n);
                        map1.put(ngram,value);
                        var++;
                    }
                }
            }
            String lastNGram="";
            for (int i = text.length()-n-1; i<text.length();i++){
                lastNGram+=text.charAt(i);
            }
        }
    }

    public boolean contains(String test){
        return this.map1.containsKey(test);
    }

    public char randomChar(String test){
        //checks if the ngram is in the map
        if(map1.containsKey(test)){
            String vars = map1.get(test);
            Random rand = new Random();
            int randInt=rand.nextInt(vars.length());
            return vars.charAt(randInt);
        }else{
            //wasnt sure how you wanted us to throw the exception
            System.out.println("ngram not found");
            return '@';
        }
    }

    public String randomStart(){
        Random rand = new Random();
        int randInt = rand.nextInt(start.size());
        return start.get(randInt);
    }

    public Map<String,String> get(){
        return this.map1;
    }
}
